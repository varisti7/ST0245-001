import time, string, random
import matplotlib.pyplot as plt

def rectangle(size2n):
    if size2n == 1 or size2n == 2: # C1
        return size2n
    else:
        return rectangle(size2n - 1) + rectangle(size2n - 2) # T(n-1) + T(n-2)

"""
    In the worst case the asynthotic complexity would be:
    T(n) = C1 + T(n-1) + T(n-2) => solved by "Laboratory practice No. 1: Recursion" point 4.4.1
    O(2^n)
"""

def plotTimes():
    timeArray = []
    lengthArray = []
    for x in range(20,40):
        t1 = time.time()
        rectangle(x)
        tt = time.time() - t1
        timeArray.append(tt)
        print(tt)
        lengthArray.append(x)
    plt.plot(lengthArray, timeArray, 'rs')
    plt.show()

def main():
    plotTimes()

main()

"""
6,20E-03
4,55E-03
1,29E-02
2,36E-02
0,04935503
0,079976082
0,100703001
0,176604033
0,24488306
0,347311974
0,278718948
0,402431965
0,634913206
1,017865181
1,632277012
2,63162899
4,297087908
6,946293831
11,17777205
18,06480503
"""