import json 
from pyproj import Transformer
import os


def extractGeomety(jsonArray):
    if (len(jsonArray[0]) == 2) and type(jsonArray[0][0]) == float:
        poligono = list()
        for elem1 in jsonArray:
            if type(elem1[0]) == list:
                print('NO VITO')
            cordinate =  transformer.transform(elem1[0],elem1[1])
            elem1[0],elem1[1] = cordinate[1],cordinate[0]
            
            
            
    else:
        for elem in jsonArray:
            extractGeomety(elem)
                


path =  r'C:\\Users\\V.Conforti\Desktop\\Progetto_distributori\\geometrie\\'

lista = os.listdir(path)
for file_name in os.listdir(path):

    print(file_name)
    with open(path+file_name, "r") as file, open(path+file_name.replace('.json','')+'_new.json', 'w') as new:
        read_content = file.read()
        dic_json = dict()
        geo_json = json.loads(read_content)
        print(type(geo_json))
        features = geo_json.get('features')
        transformer = Transformer.from_crs("EPSG:32632", "EPSG:4326")
        #regioni/prov/comuni
        lista_features = list()
        for feature in features:
            geometry = feature.get('geometry')
            coordinates = geometry.get('coordinates')
            extractGeomety(coordinates)
        json.dump(geo_json, new)

    

            
            