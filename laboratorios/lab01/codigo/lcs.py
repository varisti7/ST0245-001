import time, string, random
import matplotlib.pyplot as plt

def largestCommonSequence(string1, string2):
    """
    This algorithm takes two strings as input and compares the longest common sequence between 
    both of them; the largest common sequence doesn't have to be strictly in order.
    """
    if len(string1) == 0 or len(string2) == 0: # C1
        return 0
    elif string1[-1] == string2[-1]: 
        return 1 + largestCommonSequence(string1[:-1], string2[:-1])
    else: # C3 * T(n -1) + T(n-1)
        return max(largestCommonSequence(string1[:-1], string2), largestCommonSequence(string1, string2[:-1]))

"""
    In the worst case the asynthotic complexity would be:
    T(n) = c1 + c3 + T(n-1) + T(n-1) => solved by WolphramAlpha:
    T(n) = (2^n - 1) (c1 + c3) + c_1 2^(n - 1) => apply O notation
    O((2^n - 1) (c1 + c3) + c_1 2^(n - 1)) => apply sum rule
    O((2^n) (C) + c_1 2^(n - 1)) => apply multiplication rule
    O(2^n)
"""

def ranStrings(length):
    """
    This function generates two random strings from the alphabet
    in upper case and returns them.
    """
    alphabet = list(string.ascii_uppercase)
    newString1 = ""
    for x in range(length):
        newString1 += random.choice(alphabet)
    newString2 = ""
    for x in range(length):
        newString2 += random.choice(alphabet)
    return newString1, newString2

def plotTimes():
    """
    This function plot's the largestCommonSequence algorithm. The x label as the length of 
    the strings generated to compare and the y label as the time required to solve it.
    """
    timeArray = []
    lengthArray = []
    for x in range(1, 16):
        s1, s2 = ranStrings(x)
        t1 = time.time()
        largestCommonSequence(s1, s2)
        timeArray.append(time.time() - t1)
        lengthArray.append(x)
    plt.plot(lengthArray, timeArray, 'bo')
    plt.show()
    print(timeArray)

def main():
    plotTimes()

main()

"""
2,86E-06
5,01E-06
1,72E-05
5,72E-05
0,000192165
0,000741959
0,002493858
0,005534887
0,026319981
0,103884935
0,323891878
1,632820845
6,674180031
11,23176384
38,95291305
"""