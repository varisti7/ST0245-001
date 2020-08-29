import matplotlib.pyplot as plt
import time
import random

def insertionSort(numArray):
    x = len(numArray)
    for i in range(x): # C1 + C2*n
        cont = 0 # C3*n
        for j in range(1, i + 1): # (C4 + C5*n)*n
            if numArray[i - cont] < numArray[i - j]: # (C6*n)*n
                numArray[i - cont], numArray[i - j] = numArray[i - j], numArray[i - cont] # (C7*m)*n
            cont += 1 # C8*n
"""
T(n) = C1 + C2*n + C3*n + (C4 + C5*n)*n + (C6*n)*n + (C7*m)*n
Understanding n as the length of the array given and m as the times 
"numArray[i - cont] < numArray[i - j]" with m <= n (in the worst case m = n).
By big O notation -> O(C1 + C2*n + C3*n + (C4 + C5*n)*n + (C6*n)*n + (C7*m)*n)
By add rule -> O(C6*n^2)
By multiplication rule -> O(n^2)
"""

def main():
    def randomArr(x):
        numArr = [random.randint(0, 100) for y in range(x)]
        return numArr
    timeArray = []
    lengthArray = []
    for x in range(100,2100, 100):
        lengthArray.append(x)
        arr = randomArr(x)
        t1 = time.time()
        insertionSort(arr)
        timeArray.append(time.time() - t1)
        print(time.time() - t1)
    plt.plot(lengthArray, timeArray, 'bs')

main()

"""
This algorithm isn't the indicated for big amount of data because it is exponential, and exponential algorithm with very big 
numbers tend to be very inefficent
"""
