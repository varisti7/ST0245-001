import java.lang.Math;

public class Punto {
    private double coordenadaX;
    private double coordenadaY;
    private double radio;
    private double angulo;
    
    public Punto(){
    }
    public Punto(double coordenadaX, double coordenadaY){
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        calcularRadio();
        calcularAngulo();
    }
    private void calcularRadio() {
        this.radio = Math.sqrt(Math.pow(getCoordenadaX(), 2) + Math.pow(getCoordenadaY(), 2));
    }
    private void calcularAngulo() {
        if(getCoordenadaX() < 0 && getCoordenadaY() < 0){
            this.angulo = Math.atan((getCoordenadaY() / getCoordenadaX()) - Math.PI);
        }
        else if(getCoordenadaX() == 0 && getCoordenadaY() < 0){
            this.angulo = (- Math.PI / 2);
        }
        else if(getCoordenadaX() > 0){
            this.angulo = Math.atan(getCoordenadaY() / getCoordenadaX());
        }
        else if(getCoordenadaX() == 0 && getCoordenadaY() > 0){
            this.angulo = (Math.PI / 2);
        }
        else if(getCoordenadaX() < 0 && getCoordenadaY() >= 0){
            this.angulo = Math.atan((getCoordenadaY() / getCoordenadaX()) + Math.PI);
        }
    }
    public double getCoordenadaX() {
        return this.coordenadaX;
    }
    public double getCoordenadaY() {
        return this.coordenadaY;
    }
    public double getRadio() {
        return this.radio;
    }
    public double getAngulo() {
        return this.angulo;
    }
    public double calcularDistancia(Punto p){
        return Math.sqrt( Math.pow( (p.getCoordenadaX() - this.getCoordenadaX()), 2) +
            Math.pow( (p.getCoordenadaY() - this.getCoordenadaY()), 2));
    }
    public static void main(String[]args){
        Punto p1 = new Punto(10,20);
        System.out.println(p1.getAngulo() + " " + 
            p1.getCoordenadaX() + " " +
            p1.getCoordenadaY() + " " +
            p1.getRadio());
        Punto p2 = new Punto(0,0);
        System.out.println(p2.getAngulo() + " " + 
            p2.getCoordenadaX() + " " +
            p2.getCoordenadaY() + " " +
            p2.getRadio());
        System.out.println(p1.calcularDistancia(p2));
    }
}