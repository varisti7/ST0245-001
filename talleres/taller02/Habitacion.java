import java.util.ArrayList;
import java.util.Collections;

public class Habitacion {
    private int ancho;
    private int largo;
    private int area;

    public Habitacion(int ancho, int largo){
        this.ancho = ancho;
        this.largo = largo;
        this.area = ancho * largo;
    }
    public int getAncho() {
        return this.ancho;
    }
    public int getLargo() {
        return this.largo;
    }
    public int getArea() {
        return this.area;
    }
    public int mcd(int g, int p){
        int respuesta = 1;
        if (g % p == 0) respuesta = p;
        else respuesta = mcd(p, g % p);
        return respuesta;
    }
    public int getMcd(int largo, int ancho){
            int grande = largo;
            int pequeño = ancho;
            if (largo < ancho){
                grande = ancho;
                pequeño = largo;
            }
            return mcd(grande, pequeño);
        }

    public static void main (String[]args){
        Habitacion h1 = new Habitacion(12312, 256);
        int tamañoBaldosa = h1.getMcd(h1.getAncho(), h1.getLargo());
        System.out.println(tamañoBaldosa);
    }
}