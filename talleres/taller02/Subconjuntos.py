def subconjuntos(s):
    return subconjuntos2("", s)
def subconjuntos2(base, t):
    if t == "":
        print(base)
    else:
        subconjuntos2(base + t[0:1], t[1:])
        subconjuntos2(base, t[1:])

test = input("Ingrese la cadena de la cual quiere saber los subconjuntos ")
subconjuntos(test)