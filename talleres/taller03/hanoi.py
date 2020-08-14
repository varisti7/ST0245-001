def printHanoi(n, beg = "Tower A", aux = "Tower B", end = "Tower C"):
    if (n == 1):
        print(beg + " -> " + end)
    else:
        printHanoi(n-1, beg, end, aux)
        printHanoi(1, beg, aux, end)
        printHanoi(n-1, aux, beg, end)
        
printHanoi(3)