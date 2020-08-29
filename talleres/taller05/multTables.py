import matplotlib.pyplot as plt
import time
import random

def multTables(n):
    for i in range(1, n + 1): # C1 + C2*n
        for j in range(1, n + 1): # (C3 + C4*n)*n
            print(str(i) + ' x ' + str(j) + ' = ' + str(i*j)) # (C5*n)*n
        print('\n---------------\n') # C6*n
"""
T(n) = C1 + C2*n + (C3+ C4*n)*n + (C5*n)*n + C6*n
Understanding n as the length of the array given.
By big O notation -> O(C1 + C2*n + (C3+ C4*n)*n + (C5*n)*n + C6*n)
By add rule -> O(C5*n^2)
By multiplication rule -> O(n^2)
"""

def main():
    timeArray = []
    lengthArray = []
    for x in range(20):
        lengthArray.append(x)
        t1 = time.time()
        multTables(x)
        timeArray.append(time.time() - t1)
        print(time.time() - t1)
    plt.plot(lengthArray, timeArray, 'bs')

main()