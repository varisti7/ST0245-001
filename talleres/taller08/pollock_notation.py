class Node:
    def __init__(self, data):
        self.nextN = None
        self.data = data

class polack_notation:

    def __init__(self):
        self.result = -1
        self.SUM = '+'
        self.MULTIPLY = '*'
        self.SUBSTRACT = '-'
        self.DIVIDE = '/'
        self.chain = list()
        self.headNode = None
        self.tailNode = None
        self.operators = [self.SUM, self.MULTIPLY, self.DIVIDE, self.SUBSTRACT]

    def getResult(self):
        self.read()
        for x in self.chain:
            self.addNode(x)
        for x in range(1 if len(self.chain) == 3 else len(self.chain)//2):
            i = self.search()
            if i == -1:
                return self.result 
            self.result = self.operate(i)
            self.replace(i, self.result)
        return self.result
            
    def read(self):
        self.chain = input('Enter the chain to evaluate ').split(' ')
    
    def operate(self, position):
        current = self.headNode
        numbers = list()
        while current.data not in self.operators:
            numbers.append(current.data)
            current = current.nextN
        if current.data == self.SUM:
            self.result = int(numbers[0]) + int(numbers[1])
        elif current.data == self.MULTIPLY:
            self.result = int(numbers[0]) * int(numbers[1])
        elif current.data == self.DIVIDE:
            self.result = int(numbers[0]) / int(numbers[1])
        elif current.data == self.SUBSTRACT:
            self.result = int(numbers[0]) - int(numbers[1])
        return self.result

        
    def addNode(self, data):
        if self.headNode is None:
            self.headNode = Node(data)
            self.tailNode = self.headNode
            return
        if self.headNode == self.tailNode:
            self.headNode.nextN = Node(data)
            self.tailNode = self.headNode.nextN
            return
        current = self.tailNode
        current.nextN = Node(data)
        self.tailNode = current.nextN

    def replace(self, position, node):
        i = 1
        current = self.headNode
        while i <= position:
            current = current.nextN
            i += 1
        self.headNode = Node(node)
        self.headNode.nextN = current.nextN

    def search(self):
        current = self.headNode
        i = 1
        while current.nextN is not None:
            if current.nextN.data in self.operators:
                return i
            current = current.nextN
            i += 1
        return -1

x = polack_notation()
y = x.getResult()
print(y)
