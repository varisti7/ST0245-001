import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Principal{

    public static void habitacion(){
        String archivo = "gcd.csv";
        File fichero = new File(archivo);
        Scanner scan = null;
        try {
            scan = new Scanner(fichero);
            scan.nextLine();
            int linea = 0;
            while (scan.hasNextLine()) {
                if (linea > 0){
                    String lectura = scan.nextLine();
                    Scanner scan2 = new Scanner(lectura);
                    scan2.useDelimiter(",");
                    int numero1 = Integer.parseInt(scan2.next());
                    int numero2 = Integer.parseInt(scan2.next());
                    int respuesta = Integer.parseInt(scan2.next());
                    Habitacion h1 = new Habitacion(numero1, numero2);
                    int tamanoBaldosa = h1.getMcd(h1.getAncho(), h1.getLargo());
                    System.out.println(respuesta == tamanoBaldosa);
                    scan2.close(); 
                }
                linea++;
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scan.close();
        }
    }
    public static void inventario(){
        Inventario i1 = new Inventario(10);
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese los pesos que desea probar en el siguiente formato: numero1-numero2-....-numeroN");
        String[] accesorios = scan.next().split("-");
        i1.accesorios = new int[accesorios.length];
        for (int i = 0; i < accesorios.length; i++){
            i1.accesorios[i] = Integer.parseInt(accesorios[i]);
        }
        System.out.println("Ingrese el peso maximo");
        int target = scan.nextInt();
        System.out.println(i1.sumaGrupo(0, i1.accesorios, target));
    }

    public static void main(String args[]) {
        System.out.println("Ingrese:\n1 para probar el tamaño de las baldosas\n2 para probar el inventario");
        Scanner scan = new Scanner(System.in);
        int lector = scan.nextInt();
        switch(lector){
            case 1:
                habitacion();
            break;
            case 2:
                inventario();
            break;
        }
        scan.close();
    }
}