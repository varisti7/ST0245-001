import pandas as pd

def readData(csvName):
    return pd.read_csv(csvName, sep=';')