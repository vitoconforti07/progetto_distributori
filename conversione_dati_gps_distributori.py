from pyproj import Transformer
import pandas as pd 



transformer = Transformer.from_crs("EPSG:32632", "EPSG:4326")
path = r'C:\\Users\\V.Conforti\Desktop\\Progetto_distributori\\'
file_name = 'anagrafica_impianti_attivi.csv'
df = pd.read_csv(path+ file_name,sep=';',on_bad_lines='skip')

cordinate =  transformer.transform(df['Latitudine'],df['Longitudine'])
df['Latitudine'] = cordinate[0]
df['Longitudine'] = cordinate[1]
print('df.columns')