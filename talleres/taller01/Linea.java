public class Linea extends PuntoLinea {
    private PuntoLinea puntoInicial;
    private PuntoLinea puntoFinal;
    private PuntoLinea[] puntos;
    private int mcd;
    public static int contador = 1;

    public Linea(PuntoLinea pi, PuntoLinea pf){
        this.puntoFinal = pf;
        this.puntoInicial = pi;
        calcMcd();
        this.puntos = new PuntoLinea[calcularDifX()+ calcularDifY() + 2];
        this.puntos[0] = pi;
    }
    public int calcularDifY(){
        return (getPFinal().getCoordenadaY() - getPInicial().getCoordenadaY());
    }
    public int calcularDifX(){
        return (getPFinal().getCoordenadaX() - getPInicial().getCoordenadaX());
    }
    public PuntoLinea getPFinal(){
        return this.puntoFinal;
    }
    public PuntoLinea getPInicial(){
        return this.puntoInicial;
    }
    public int getMcd(){
        return this.mcd;
    }
    public PuntoLinea[] getLista(){
        return this.puntos;
    }
    public void getPuntos(){
        int x = calcularDifX() / getMcd();
        int y = calcularDifY() / getMcd();
        int i = 0;
        
        while(i < getMcd()){
            int xi = getLista()[contador - 1].getCoordenadaX() + 1;
            int yi = getLista()[contador - 1].getCoordenadaY();
            for (int j = xi; j < xi + x; ++j){
                    PuntoLinea p = new PuntoLinea(j, yi);
                    getLista()[contador] = p;
                    contador++;
            }
            xi = getLista()[contador - 1].getCoordenadaX();
            yi = getLista()[contador - 1].getCoordenadaY() + 1;
            for (int k = yi; k < yi + y; ++k){
                    PuntoLinea p = new PuntoLinea(xi, k);
                    getLista()[contador] = p;
                    contador++;
            }
            i++;
        }
        getLista()[contador - 1] = getPFinal();
    }

    public void calcMcd() {
        int grande = calcularDifY();
        int chiquito = calcularDifX();
        if (calcularDifX() > calcularDifY()){
            grande = calcularDifX();
            chiquito = calcularDifY();
        }
        this.mcd = mcd(grande, chiquito);
    }
    public int mcd(int p, int q){
        int result = 1;
        if (p % q == 0) result = q;
        else  result = mcd(q, p % q);
        return result;
    }
    public static void main (String[]args){
        PuntoLinea pi = new PuntoLinea(1,4);
        PuntoLinea pf = new PuntoLinea(41,24);
        Linea linea = new Linea(pi, pf);
        linea.getPuntos();
        for (int i = 0; i < linea.getLista().length - 1; i++){
            System.out.println(linea.getLista()[i].toString());
        }
    }
}