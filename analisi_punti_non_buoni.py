import psycopg2
import pandas as pd
import json
from shapely.geometry import Polygon

database_name = 'Progetto_distributori_V_0.1'
host = 'localhost' 
porta = 5432
user = 'Vito'
password = 'vito'
schema = 'v_0_1'
string_query = 'select * from comune c where c.nome_comune = '
path = r'C:\\Users\\V.Conforti\Desktop\\'
path_scrittura = r'C:\\Users\\V.Conforti\Desktop\\Progetto_distributori\\test\\'


geo_json_string = '{"type":"FeatureCollection","features":[{"type":"Feature","properties":{},"geometry":{}},{"type":"Feature","properties":{},"geometry":{"coordinates":[],"type":"Point"}}]}'



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
    lista_regione = cursor.fetchone()
    return lista_regione 


df = pd.read_csv(path+'punto_non_buoni.csv')
conn =  open_connessione_database(database_name,host,porta,schema, user,password)
for index, row in df.iterrows():
   nome_comune =  row['nomeComune']
   nome_comune = nome_comune.replace('\'','\''+'\'')
   comune = get_comune_from_database(conn, string_query +'\'' + nome_comune +'\'')
    
   geo_json = json.loads(geo_json_string)
   features = geo_json.get('features')
   poligono = features[0].get('geometry')
   poligono = comune[4]
   punto = features[1].get('geometry')
   coordinates_punto  = punto.get('coordinates')
   coordinates_punto = [row['lonPunto'],row['lantPunto']]
   geo_json.get('features')[0]['geometry']= json.loads(poligono)
   geo_json.get('features')[1]['geometry']['coordinates'] = coordinates_punto
   with open( path_scrittura+nome_comune+'.json',mode= 'w') as f:
    j = json.dumps(geo_json)
    f.write(j)
   
   
   

