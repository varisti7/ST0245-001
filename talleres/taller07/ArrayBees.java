public class ArrayBees {
    public Node head;

    public void addBee(int position, Bees bee) throws Exception {
        if(position == 0){
            Node headBee = new Node(bee);
            headBee.next = head;
            head = headBee;
            return;
        }
        int i = 1;
        Node current = head;
        while(i < position){
            current = current.next;
            i++;
        }
        Node temp = current.next;
        current.next = new Node(bee);
        current.next.next = temp;
    }
    public void addBee(Bees bee) throws Exception {
        if(head == null) {
            head = new Node(bee);
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Node(bee);
    }
    public void deleteBee(int position) throws Exception {
        if(position == 0){
            head = head.next;
        }
        int i = 1;
        Node current = head;
        while(i < position){
            current = current.next;
            i++;
        }
        current.next = current.next.next;
    }
    public String search(String name){
        Node current = head;
        int i = 0;
        while(current.next != null){
            if(current.bee.name.equals(name)){
                return "The Bee '" + name + "' is in the position " + i;
            }
            current = current.next;
            i++;
        }
        return "The Bee '" + name + "' is not in the list";
    }
    public static void main(String [] args) throws Exception {
        Bees b1 = new Bees(1, 1, "fulanito1");
        Bees b2 = new Bees(2, 2, "fulanito2");
        Bees b3 = new Bees(3, 3, "fulanito3");
        Bees b4 = new Bees(4, 4, "fulanito4");
        Bees b5 = new Bees(5, 5, "fulanito5");
        Bees b6 = new Bees(6, 6, "fulanito6");
        Bees b7 = new Bees(7, 7, "fulanito7");
        Bees b8 = new Bees(8, 8, "fulanito8");
        Bees b9 = new Bees(9, 9, "fulanito9");
        Bees b10 = new Bees(10, 10, "fulanito10");
        Bees b11 = new Bees(100, 200, "fulanito11");
        ArrayBees a = new ArrayBees();
        a.addBee(b1);
        a.addBee(b2);
        a.addBee(b3);
        a.addBee(b4);
        a.addBee(b5);
        a.addBee(b6);
        a.addBee(b7);
        a.addBee(2, b8);
        a.addBee(8, b9);
        a.addBee(9, b10);
        a.addBee(1, b11);
        a.deleteBee(2);
        a.addBee(b11);
        System.out.println(a.search("fulanito8"));
        System.out.println(a.search("fulanito22"));
    }
}
/* The complexity of this algorithm may not be adecuate to use with a million of
* bees because its O(n^2).
* The complexity of adding n bees would be n^2.
*/
