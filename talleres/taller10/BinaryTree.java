public class BinaryTree {

    private Node root;

    public BinaryTree() {
        this.root = null;
    }
    public BinaryTree(int n) {
        this.root = new Node(n);
    }

    public void add(int n) {
        addAux(root, n);
    }
    private void addAux(Node node, int n) {
        if (node.data == n){
            return;
        }else if (n > node.data) {
            if (node.right == null) {
                node.right = new Node(n);
            }else {
                addAux(node.right, n);
            }
        }else {
            if (node.left == null) {
                node.left = new Node(n);
            }else {
                addAux(node.left, n);
            }
        }
    }

    public boolean find(int n) {
        return findAux(root, n);
    }

    private boolean findAux(Node node, int n) {
        if (node.data == n) {
            return true;
        }
        if (n > node.data) {
            return findAux(node.right, n);
        }
        return findAux(node.left, n);
    }

    public void delete(int n) {
        deeleteAux(root, n);
    }

    private Node deeleteAux(Node node, int n) {
        if (node == null) {
            return null;
        }
        if (node.data == n) {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }else {
                node.data = findReeplacement(node.left);
            }
        }
        if (n > node.data) {
            node.right = deeleteAux(node.right, n);
            return node;
        }
        node.left = deeleteAux(node.left, n);
        return node;
    }

    private int findReeplacement(Node n) {
        if (n.right == null) {
            int res = n.data;
            n = null;
            return res;
        }
        return findReeplacement(n.right);
    }
    
    private void generateDataAux(){
        generateData(this.root, "");
    }
    
    // la complejidad de este algoritmo es de O(n)
    private void generateData(Node n, String text){
        Node current = n;
        if (current.left != null) {
            generateData(current.left, text);
            System.out.println(current.data + "->" + current.left.data + "\n");
        }
        if (current.right != null) {
            generateData(current.right, text);
            System.out.println(text += current.data + "->" + current.right.data) ;
        }
    }

    private class Node{
    public Node left, right;
    public int data;

    public Node(int data) {
        this.left = null;
        this.right = null;
        this.data = data;
        }
    }

    public static void main (String[]args){
        BinaryTree bt = new BinaryTree(10);
        bt.add(8);
        bt.add(15);
        bt.add(2);
        bt.add(4);
        bt.add(12);
        bt.add(20);
        bt.add(23);
        bt.add(1);
        bt.add(11);
        bt.add(18);
        bt.add(7);
        bt.add(6);
        bt.add(5);
        bt.add(13);
        bt.add(9);
        bt.add(3);
        bt.generateDataAux();
    }
}