public class Fridge {
    public int data;
    public String description;
    public Fridge next;
    public Fridge previous;
    public Fridge(int data, String description){
        next = null;
	    this.data = data;
	    this.description = description;

    }
}