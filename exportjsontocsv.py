import pandas as pd
import json

path_csv_file = r'C:\\Users\\V.Conforti\Desktop\\Progetto_distributori\\punti_comuni.csv'
path_json_file = r'C:\\Users\\V.Conforti\Desktop\\punto_non_buoni.json'


df = pd.read_csv(path_csv_file)

#df_new = pd.DataFrame(columns = df.columns)
lista_id_regione = list()
with open(path_json_file, "r") as file:
    read_content = file.read()
    jsons = json.loads(read_content)
    for j in jsons:
        puntoInComune = j.get('puntoInComune')
        id_regione = puntoInComune.get('id_regione')
        lista_id_regione.append(id_regione)

mask = df['id_regione'].isin(lista_id_regione)
df_new = df[mask]
df_new.to_csv('C:\\Users\\V.Conforti\Desktop\\Progetto_distributori\\punto_non_buoni.csv')
print('ok')
    