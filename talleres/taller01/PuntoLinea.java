public class PuntoLinea {
    private int coordenadaX;
    private int coordenadaY;
    
    public PuntoLinea(){
    }
    public PuntoLinea(int coordenadaX, int coordenadaY){
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        
    }
    public int getCoordenadaX() {
        return this.coordenadaX;
    }
    public int getCoordenadaY() {
        return this.coordenadaY;
    }
    public String toString(){
        return "(" + getCoordenadaX() + "," + getCoordenadaY() + ")";
    }
}