from __future__ import print_function
from readData import readData
import numpy as np
import math
import datetime

header = [
        'estu_exterior',
        'fami_numlibros',
        'estu_valorpensioncolegio',
        'fami_educacionpadre.1',
        'fami_educacionmadre.1',
        'fami_ocupacionpadre.1',
        'fami_ocupacionmadre.1',
        'fami_estratovivienda.1',
        'fami_tieneinternet.1',
        'fami_tienecomputador.1',
        'fami_tiene_celular.1',
        'fami_ingresofmiliarmensual',
        'cole_calendario',
        'cole_bilingue',
        'cole_caracter',
        'punt_lenguaje',
        'punt_matematicas',
        'punt_biologia',
        'punt_quimica',
        'punt_fisica',
        'punt_ciencias_sociales',
        'punt_filosofia',
        'punt_ingles',
        'desemp_ingles',
        'puntaje_prof'
    ]

def readInfo(trainName, testName):
    dataframe = readData(trainName + '.csv')
    dataframe2 = readData(testName + '.csv')

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
        'profundiza',

        'cole_nombre_establecimiento',
        'cole_nombre_establecimiento',
        'cole_genero',
        'cole_naturaleza',
        'periodo.1',
        'estu_fechanacimiento.1',
        'estu_inst_cod_departamento',
        'periodo',
        'estu_consecutivo.1'
    ]

    for variable in [NaN_variables, no_aportan_variables, unethical_variables]:
        dataframe.drop(variable, axis=1, inplace=True)

    for variable in [NaN_variables, no_aportan_variables, unethical_variables]:
        dataframe2.drop(variable, axis=1, inplace=True)


    training_data = dataframe.to_numpy().tolist()
    for el in training_data:
        x=0
        for ele in el:
            if type(ele) is not str and math.isnan(ele):
                el[x] = '-'
            x+=1

    testing_data = dataframe2.to_numpy().tolist()
    for el in testing_data:
        x=0
        for ele in el:
            if type(ele) is not str and math.isnan(ele):
                el[x] = '-'
            x+=1
    
    return training_data, testing_data

    

def unique_vals(rows, col):
    return set([row[col] for row in rows])

def class_counts(rows):
    counts = {}
    for row in rows:
        label = row[-1]
        if label not in counts:
            counts[label] = 0
        counts[label] += 1
    return counts

def is_numeric(value):
    return isinstance(value, int) or isinstance(value, float)

class Question:
    def __init__(self, column, value):
        self.column = column
        self.value = value

    def match(self, example):
        val = example[self.column]
        if is_numeric(val):
            return val >= self.value
        else:
            return val == self.value

    def __repr__(self):
        condition = "=="
        if is_numeric(self.value):
            condition = ">="
        return "Is %s %s %s?" % (
            header[self.column], condition, str(self.value))

def partition(rows, question):
    true_rows, false_rows = [], []
    for row in rows:
        if question.match(row):
            true_rows.append(row)
        else:
            false_rows.append(row)
    return true_rows, false_rows

def gini(rows):
    counts = class_counts(rows)
    impurity = 1
    for lbl in counts:
        prob_of_lbl = counts[lbl] / float(len(rows))
        impurity -= prob_of_lbl**2
    return impurity


def info_gain(left, right, current_uncertainty):
    p = float(len(left)) / (len(left) + len(right))
    return current_uncertainty - p * gini(left) - (1 - p) * gini(right)

def find_best_split(rows):
    best_gain = 0
    best_question = None
    current_uncertainty = gini(rows)
    n_features = len(rows[0]) - 1

    for col in range(n_features):

        values = set([row[col] for row in rows])

        for val in values:

            question = Question(col, val)
            true_rows, false_rows = partition(rows, question)
            if len(true_rows) == 0 or len(false_rows) == 0:
                continue
            gain = info_gain(true_rows, false_rows, current_uncertainty)
            if gain >= best_gain:
                best_gain, best_question = gain, question

    return best_gain, best_question

class Leaf:

    def __init__(self, rows):
        self.predictions = class_counts(rows)


class Decision_Node:
    def __init__(self,
                 question,
                 true_branch,
                 false_branch, gain):
        self.question = question
        self.true_branch = true_branch
        self.false_branch = false_branch
        self.gain = gain


def build_tree(rows):
    gain, question = find_best_split(rows)

    if gain == 0:
        return Leaf(rows)
    true_rows, false_rows = partition(rows, question)
    true_branch = build_tree(true_rows)
    false_branch = build_tree(false_rows)
    return Decision_Node(question, true_branch, false_branch, gain)


def print_tree(node, spacing=""):
    if isinstance(node, Leaf):
        print (spacing + "Predict", node.predictions)
        return

    print (spacing + str(node.question) + '  impureza gini gain ' + str(node.gain)[:6])

    print (spacing + '--> True:')
    print_tree(node.true_branch, spacing + "  ")

    print (spacing + '--> False:')
    print_tree(node.false_branch, spacing + "  ")


def classify(row, node):
    if isinstance(node, Leaf):
        return node.predictions

    if node.question.match(row):
        return classify(row, node.true_branch)
    else:
        return classify(row, node.false_branch)

def print_leaf(counts):
    total = sum(counts.values()) * 1.0
    probs = {}
    for lbl in counts.keys():
        probs[lbl] = str(int(counts[lbl] / total * 100)) + "%"
    return probs

def run(td, trd, training_data, testing_data):
    t1 = datetime.datetime.now()
    my_tree = build_tree(training_data)
    print(datetime.datetime.now() - t1)
    print('\nTraining data: ' + trd + '\n')
    print_tree(my_tree)
    print('\nTesting data: ' + td + '\n')
    t1 = datetime.datetime.now()
    for row in testing_data:
        print ("Actual: %s. Predicted: %s" %
                (row[-1], print_leaf(classify(row, my_tree))))
    print(datetime.datetime.now() - t1)

for x in range(5):
    tname = str(x) + '_test_balanced_' + str(10000*x+5000)
    trname = str(x) + '_train_balanced_' + str(30000*x+15000)
    train, test = readInfo(trname, tname)
    run(tname, trname, train, test)