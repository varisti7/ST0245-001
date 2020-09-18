public class LinkedList {
    public Node head, tail;
    public int length = 0;

    public void addNode(int data) throws Exception {
        if(head == null) {
            head = new Node(data);
            tail = head;
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Node(data);
        tail = current.next;
        current.next.previous = current;
        length++;
    }
    public boolean palindrome(){
        Node current, last;
        current = head;
        last = tail;
        for(int i = 0; i <= length/2; i++){
            if(current.data != last.data){
                return false;
            }
            current = current.next;
            last = last.previous;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        LinkedList l1 = new LinkedList();
        l1.addNode(1);
        l1.addNode(2);
        l1.addNode(3);
        l1.addNode(3);
        l1.addNode(2);
        l1.addNode(1);
        System.out.println(l1.palindrome());
    }
}