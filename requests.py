import requests 
import pandas as pd
a =  r'C:\\Users\\V.Conforti\\Desktop\\Progetto_distributori\\'
b = 'punti_comuni.csv'
df =  pd.read_csv(a+b)

#r =  requests.get('http://localhost:8080/distributori/getComune?lon=45.205285&lant=6.9825')

print('r')