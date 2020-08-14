def permutaciones(palabra, base = "", lista = []):
    if (palabra == ""):
        lista.append(base)
        print(base)
    else:
        permutaciones(palabra[1:], base + palabra[0:1], lista)
        permutaciones(palabra[1:], base, lista)
    return lista

lista = permutaciones("abc")
print(lista)