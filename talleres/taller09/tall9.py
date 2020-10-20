# Punto 1
print('Punto 1:')
class HashTable():
    
    def __init__(self):
        self.tabla = []
        for i in range(10):
            self.tabla.append([])

    # Noob hash_function
    def funcion_hash(self, k):
        return (ord(k[0].upper()) - ord('A')) % 10 # ord() me da el ascii

    def get(self, k):
        aux = self.tabla[self.funcion_hash(k)]
        for t in aux:
            if t[0] == k:
                return t
        return -1

    def put(self, k, v):       
        self.tabla[self.funcion_hash(k)].append((k, v))

hash = HashTable()
hash.put('hola', 3)
hash.put('hi', 4)
print(hash.get('hola'))
print(hash.get('hi'))
print(hash.get('ho'))
print(hash.tabla)

# Punto 2
print('Punto 2:')
empresas = {'Google': 'Estados Unidos',
            'La Locura': 'Colombia',
            'Nokia': 'Finlandia',
            'Sony': 'Japon'}

for k, v in empresas.items():
    print(k, v)

# Punto 3
print('Punto 3:')
print(empresas.get('Google'))
print(empresas.get('Motorola'))

# Punto 4
print('Punto 4:')
paises = empresas.values()
print('India' in paises)
print('Estados Unidos' in paises)