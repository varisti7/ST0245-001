import java.util.Arrays;

public class ArrayBees {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Bees elements[];

    public ArrayBees(){
        elements = new Bees[DEFAULT_CAPACITY];
        size = 0;
    }
    public int size(){
        return this.size;
    }
    public Bees[] elements() {
        return this.elements;
    }
    public void setElements() {
        if(size() != 0 && size() % 10 == 0){
            this.elements = Arrays.copyOf(this.elements, size + 10);
        }
    }
    public void addBee(int position, Bees bee) throws Exception {
        setElements();
        if(position > size()) throw new Exception("IndexOutOfBounds");
        Bees[] element = Arrays.copyOf(this.elements, size());
        for(int i = 0; i < position; i++){
            this.elements[i] = element[i];
        }
        this.elements[position] = bee;
        for(int i = position; i < size(); i++){
            this.elements[i + 1] = element[i];
        }
        this.size++;
    }
    public void addBee(Bees bee) throws Exception {
        setElements();
        this.elements[size()] = bee;
        this.size++;
    }
    public void deleteBee(int position) throws Exception {
        if(position > size()) throw new Exception("IndexOutOfBounds");
        Bees[] element = new Bees[size()];
        for(int i = 0; i < position; i++){
            element[i] = this.elements[i];
        }
        for(int i = position; i < size(); i++){
            element[i] = this.elements[i + 1];
        }
        this.elements = element;
        this.size--;
    }
    public static void main(String [] args) throws Exception {
        Bees b1 = new Bees(1, 1);
        Bees b2 = new Bees(2, 2);
        Bees b3 = new Bees(3, 3);
        Bees b4 = new Bees(4, 4);
        Bees b5 = new Bees(5, 5);
        Bees b6 = new Bees(6, 6);
        Bees b7 = new Bees(7, 7);
        Bees b8 = new Bees(8, 8);
        Bees b9 = new Bees(9, 9);
        Bees b10 = new Bees(10, 10);
        Bees b11 = new Bees(100, 200);
        ArrayBees a = new ArrayBees();
        a.addBee(0, b1);
        a.addBee(1, b2);
        a.addBee(2, b3);
        a.addBee(3, b4);
        a.addBee(4, b5);
        a.addBee(5, b6);
        a.addBee(6, b7);
        a.addBee(7, b8);
        a.addBee(8, b9);
        a.addBee(9, b10);
        for (Bees bee : a.elements()) {
            if(bee != null) System.out.println("(" + bee.x + "," + bee.y + ")");
            else break;
        }
        a.addBee(1, b11);
        a.deleteBee(6);
        a.addBee(b11);
        System.out.println("\n==============\n");
        for (Bees bee : a.elements()) {
            if(bee != null) System.out.println("(" + bee.x + "," + bee.y + ")");
            else break;
        }
    }
}
/* The complexity of this algorithm may not be adecuate to use with a million of
* bees because its O(n^2).
* The complexity of adding n bees would be n^2.
*/
