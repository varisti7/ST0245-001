from readData import readData

dataframe = readData('lite.csv')

unethical_variables = ['estu_tieneetnia',
    'estu_tipodocumento.1',
    'fami_trabajolaborpadre',
    'fami_trabajolabormadre',
    'estu_genero.1',
    'estu_pais_reside.1',
    'estu_depto_reside.1',
    'estu_cod_reside_depto.1',
    'estu_mcpio_reside.1',
    'estu_cod_reside_mcpio.1',
    'estu_areareside',
    'fami_nivelsisben',
    'fami_pisoshogar',
    'fami_tienemicroondas',
    'fami_tienehorno',
    'fami_tieneautomovil.1',
    'fami_tienedvd',
    'fami_tiene_nevera.1',
    'estu_nacionalidad.1',
    'fami_telefono.1',
    'estu_trabajaactualmente',
    'estu_antecedentes',
    'estu_expectativas',
    'cole_cod_dane_establecimiento',
    'cole_cod_dane_sede',
    'cole_area_ubicacion',
    'cole_jornada',
    'cole_cod_mcpio_ubicacion',
    'cole_mcpio_ubicacion',
    'cole_cod_depto_ubicacion',
    'cole_depto_ubicacion']

NaN_variables = [
    'estu_tomo_cursopreparacion',
    'estu_cursodocentesies',
    'desemp_prof',
    'estu_cursoiesapoyoexterno',
    'estu_cursoiesexterna',
    'estu_simulacrotipoicfes',
    'estu_actividadrefuerzoareas',
    'estu_actividadrefuerzogeneric'
]

no_aportan_variables = [
    'estu_estudiante.1',
    'cole_sede_principal',
    'cole_nombre_sede',
    'cole_codigo_icfes',
    'profundiza'
]

for variable in [NaN_variables, no_aportan_variables, unethical_variables]:
    dataframe.drop(variable, axis=1, inplace=True)

# for col in dataframe.columns:
#     print(dataframe[col])
# print(dataframe)

name = dict()
for (columnName, columnData) in dataframe.iteritems():
   name[columnName] = []
   name[columnName] = list(columnData.values)

def arreglar_estrato():
    x = 0
    for estrato in name['fami_estratovivienda.1']:
        if estrato == 'Estrato 1':
            name['fami_estratovivienda.1'][x] = 1
        if estrato == 'Estrato 2':
            name['fami_estratovivienda.1'][x] = 2
        if estrato == 'Estrato 3':
            name['fami_estratovivienda.1'][x] = 3
        if estrato == 'Estrato 4':
            name['fami_estratovivienda.1'][x] = 4
        if estrato == 'Estrato 5':
            name['fami_estratovivienda.1'][x] = 5
        if estrato == 'Estrato 6':
            name['fami_estratovivienda.1'][x] = 6
        x+=1

def calcular_impureza_valor(asignacion, exito, operador):
    guini_list = list()
    for i in range(101):
        n0 = 0
        n1 = 0
        for x in range(len(asignacion)):
            if eval(str(asignacion[x]) + operador + str(i)) and exito[x] == 1:
                n1 += 1
            else:
                n0 += 1
        p0 = n0 / (n0 + n1)
        p1 = n1 / (n0 + n1)
        ig = 1 - (p0**2 + p1**2)
        guini_list.append((i, ig))

    return guini_list

guini_list = calcular_impureza_valor(name['punt_filosofia'], name['exito'], '>=')
arreglar_estrato()

subject_names = [
    'punt_lenguaje',
    'punt_matematicas',
    'punt_biologia',
    'punt_quimica',
    'punt_fisica',
    'punt_ciencias_sociales',
    'punt_filosofia',
    'punt_ingles',
]

def guini_indexes(subject_names):
    subjects = dict()
    for subject in subject_names:
        subjects[subject] = calcular_impureza_valor(name[subject], name['exito'], '>=')
    return subjects

print(guini_indexes(subject_names))