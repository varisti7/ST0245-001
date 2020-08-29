import random, time
import matplotlib.pyplot as plt

def sumArray(numArray):
    total = 0 # C1
    for x in range(len(numArray)): # C2 + C3*n
        total += numArray[x] # C4*n
    return total # C5
"""
T(n) = C1 + C2 + C3*n + C4*n + C5
Understanding n as the length of the array given.
By big O notation -> O(C1 + C2 + C3*n + C4*n + C5)
By add rule -> O(C4*n)
By multiplication rule -> O(n)
"""

def main():
    def randomArr(x):
        numArr = [random.randint(0, 100) for y in range(x)]
        return numArr
    timeArray = []
    lengthArray = []
    for x in range(100000, 2100000, 100000):
        lengthArray.append(x)
        arr = randomArr(x)
        t1 = time.time()
        sumArray(arr)
        timeArray.append(time.time() - t1)
        print(time.time() - t1)
    plt.plot(lengthArray, timeArray, 'bs')

main()

"""
Yes, because with recursion the OS has to open more resources to resolve the algorithm and it becomes
an algorithm with 2^n complecity, meanwhile with loops the algorithm only opens one resource and the complexity
becomes n
"""