public class Baldosas {
    private int lado;
    private int area;

    public Baldosas(int lado){
        this.lado = lado;
        this.area = lado*lado;
    }
    public int getLado() {
        return this.lado;
    }
    public int getArea() {
        return this.area;
    }
}