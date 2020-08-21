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
    else:
        esta = groupSum_aux(start + 1, lista, target - lista[start])
        noesta = groupSum_aux(start + 1, lista, target)
        return esta or noesta

def groupSum(lista, target):
   return groupSum_aux(0, lista, target)


lengthArray = []
timeArray = []
for x in range (8 ,28):
    arr = array_generator(x)
    num = random.choice(range(150))
    lengthArray.append(x)
    t1 = time.time()
    groupSum_aux(0, arr, num)
    t2 = time.time()
    print((t2-t1)*1000)
    timeArray.append(t2 - t1)
plt.plot(lengthArray, timeArray, 'ro')
plt.show()


lengthArray2 = []
timeArray2 = []
for x in range (1000,10001,500):
    arr = array_generator(x)
    lengthArray2.append(len(arr))
    t1 = time.time()
    arrayMax_aux(arr, 0, 0)
    t2 = time.time()
    print((t2-t1)*1000)
    timeArray2.append(t2 - t1)
plt.plot(lengthArray2, timeArray2, 'bs')
plt.show()

