import random
import matplotlib.pyplot as plt
import time
import sys

sys.setrecursionlimit(1000000000)

def array_generator(len):
    """List generator"""
    choices = list(range(len))
    array = []
    for x in range(len):
        array.append(random.choice(choices))
    return array
 
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

def groupSum_aux(start, lista, target):
    if start == len(lista):
        return target == 0
    return groupSum_aux(start + 1, lista, target - lista[start]) or groupSum_aux(start + 1, lista, target)

def groupSum(lista, target):
   return groupSum_aux(0, lista, target)

# #----------------------------Fibonacci---------------------------------#

# def fib_r(n):                             #Fibonacci recursivo

lengthArray = []
timeArray = []
for x in range (1,22):
    arr = array_generator(x)
    num = random.choice(range(150))
    lengthArray.append(x)
    t1 = time.time()
    print(groupSum_aux(0, arr, num))
    t2 = time.time()
    timeArray.append(t2 - t1)
plt.plot(lengthArray, timeArray)
plt.show()

lengthArray = []
timeArray = []
for x in range (100,1101,50):
    arr = array_generator(x)
    lengthArray.append(len(arr))
    t1 = time.time()
    print(arrayMax_aux(arr, 0, 0))
    t2 = time.time()
    timeArray.append(t2 - t1)
plt.plot(lengthArray, timeArray)
plt.show()

