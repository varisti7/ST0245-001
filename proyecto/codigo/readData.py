import pandas as pd

def readData(csvName):
    return pd.read_csv(csvName, sep=';')

data = readData(input('Ingrese el nombre del archivo a leer'))
print('A continuacion se muestran los primeros resultados del archivo leido: ')
print(data.head())
print('Y adicional el tamaño de la matriz: ')
print(data.shape)
