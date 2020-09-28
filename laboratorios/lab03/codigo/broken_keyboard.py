class Node:
    def __init__(self, data):
        self.nextN = None
        self.data = data

class broken_keyboard:

    def __init__(self):
        self.chain = list()
        self.headNode = None
        self.tailNode = None
        self.read()
        self.assign()
        self.new_string()
            
    def read(self):
        self.chain = input('Enter the chain to evaluate ').split('[')
        words = ''
        for x in self.chain:
            words += x + ' [ '
        self.chain = words.split(']')
        words = ''
        for x in self.chain:
            words += x + ' ] '
        self.chain = list(filter(lambda word: word != '', [ x.strip() for x in words.split(' ') ]))
        
    def addTail(self, data):
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

    def addHead(self, data):
        current = self.headNode
        self.headNode = Node(data)
        self.headNode.nextN = current

    def assign(self):
        x = 0
        while x < len(self.chain):
            if x + 1 < len(self.chain) and self.chain[x] == '[':
                if self.chain[x+1] != '[' and self.chain[x+1] != ']':
                    self.addHead(self.chain[x+1])
                    x+=1
                x+=1
            elif x + 1 < len(self.chain) and self.chain[x] == ']':
                if self.chain[x+1] != '[' and self.chain[x+1] != ']':
                    self.addTail(self.chain[x+1])
                    x+=1
                x+=1
            else:
                if self.chain[x] != '[' and self.chain[x] != ']':
                    self.addTail(self.chain[x])
                x+=1

    def new_string(self):
        current = self.headNode
        new_string = ''
        while current.nextN != None:
            new_string += current.data
            current = current.nextN
        new_string += current.data
        print(new_string)

x = broken_keyboard()