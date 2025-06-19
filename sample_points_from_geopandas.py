import psycopg2
import geopandas, pandas as pd
import json
from shapely.geometry import Polygon
import random

database_name = 'Progetto_distributori_V_0.1'
host = 'localhost' 
porta = 5432
user = 'Vito'
password = 'vito'
schema = 'v_0_1'
string_query = 'select * from comune c'

def open_connessione_database(database_name,host,porta,schema, user,password):
    conn = psycopg2.connect(database=database_name,
                            host=host,
                            user=user,
                            password=password,
                            port=porta,
                            options=f'-c search_path={schema}')
    return conn


def disconnessione_database(conn):
    conn.close()

def get_comune_from_database(conn, query):         
    cursor = conn.cursor()
    
    cursor.execute(query)
    lista_regione = cursor.fetchall()
    return lista_regione 

def extractGeomety(jsonArray, poligoni):
    if (len(jsonArray[0]) == 2) and type(jsonArray[0][0]) == float:
        poligono = Polygon(jsonArray)
        poligoni.append(poligono)
    else:
        for elem in jsonArray:
            extractGeomety(elem, poligoni)
                




def punto_in_regione(comune_from_database):
        poligoni = list()
        geometria = comune_from_database[4]
        geo_json = json.loads(geometria)
        coordinates = geo_json.get('coordinates')
        extractGeomety(coordinates, poligoni)
        s =  geopandas.GeoSeries(poligoni)
        punti =  s.sample_points(size=1)
        punto = ''
        punto = punti[random.randint(0, len(punti)-1)]
        lant_punto, lon_punto = punto.x, punto.y
        comune = comune_from_database[0],comune_from_database[1],comune_from_database[2],lant_punto, lon_punto
        
        return comune
        

conn =  open_connessione_database(database_name,host,porta,schema, user,password)
lista_comuni = get_comune_from_database(conn, string_query)
disconnessione_database(conn)
df = pd.DataFrame(columns =['id_regione', 'cod_regione','nome_regione','lant punto','lon punto'])
for comune_from_database  in lista_comuni:

    regione_con_punto =  punto_in_regione(comune_from_database)
    df.loc[len(df.index)] = regione_con_punto
path = r'C:\\Users\\V.Conforti\Desktop\\Progetto_distributori\\'
df.to_csv(path+'punti_comuni.csv', index=False)
print('finito')