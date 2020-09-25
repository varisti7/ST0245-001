import java.util.LinkedList;
import java.util.Queue;

public class Fridges {
    public Fridge head, tail;
    public int length = 0;

    public void addFridge(int data, String description) throws Exception {
        if(head == null) {
            head = new Fridge(data, description);
            tail = head;
            return;
        }
        Fridge current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Fridge(data, description);
        tail = current.next;
        current.next.previous = current;
        length++;
    }
    public void assign(Queue<Order> orders){
        for (Order q: orders){
            Fridge current = tail;
            int i = 0;
            while(i < q.quantity){
                System.out.println("Fridge # " + current.data + " with description " + current.description + " -> " + q.name);
                current = current.previous;
                i++;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Queue<Order> orders = new LinkedList<Order>();
        Order o1 = new Order(2, "tienda");
        Order o2 = new Order(2, "pepito");
        Order o3 = new Order(1, "juan");
        Fridges l1 = new Fridges();
        l1.addFridge(1, "si");
        l1.addFridge(2, "sii");
        l1.addFridge(3, "siii");
        l1.addFridge(3, "siiii");
        l1.addFridge(2, "siiiii");
        l1.addFridge(1, "siiiiii");
        orders.offer(o1);
        orders.offer(o2);
        orders.offer(o3);
        l1.assign(orders);
    }
}