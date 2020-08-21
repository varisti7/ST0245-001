import random
from matplotlib import pyplot as pl
import time

# def array_generator(len):
#     """List generator"""
   

# def array_sum(array, sum = 0):
#     """Add the elements in the list"""
 

def multiplication_tables(n):
    for i in range(1,n + 1):
        for j in range(1,n + 1):
            print (str(i) + " * " + str(j) + " = " + str(i*j))
        print ("--------------------")


# def insertion_sort(list):
  

def arrayMax(arr):
    return arrayMax_aux(arr, 0, 0)

def arrayMax_aux(arr, i, max):
    if i == 0 or arr[i] > max:
        max = arr[i]
    if i == len(arr) - 1:
        return max
    else:
        max = arrayMax_aux(arr, i + 1, max)
        return max

# def groupSum_aux(list, start, target):
  

# def groupSum(list, target):
   

# #----------------------------Fibonacci---------------------------------#

# def fib_r(n):                             #Fibonacci recursivo

lista = [102,4,5,98,3,45,101]
print(arrayMax(lista))