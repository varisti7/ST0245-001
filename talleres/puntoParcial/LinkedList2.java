public class LinkedList2 {
    public Node2 head;
    public int length = 0;

    public void addNode2(int data) throws Exception {
        if(head == null) {
            head = new Node2(data);
            return;
        }
        Node2 current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Node2(data);
        length++;
    }
    public boolean palindrome(){
        Node2 currentFirst = head;
        Node2 currentLast = currentFirst;
        for(int i = 0; i <= length/2; i++){
            currentLast = currentFirst;
            for(int j = i; j <= length - i; j++){
                if(j == length - i){
                    if(currentFirst.data != currentLast.data){
                        return false;
                    }
                }
                currentLast = currentLast.next;
            }
            currentFirst = currentFirst.next;
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        LinkedList2 l1 = new LinkedList2();
        l1.addNode2(1);
        l1.addNode2(2);
        l1.addNode2(3);
        l1.addNode2(3);
        l1.addNode2(2);
        l1.addNode2(1);
        System.out.println(l1.palindrome());
    }
}