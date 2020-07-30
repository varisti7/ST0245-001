public class Fecha {
    private int dia;
    private int mes;
    private int año;

    public Fecha(int dia, int mes, int año){
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }
    public Fecha(String fecha){
        this(convertirFecha(fecha)[0], convertirFecha(fecha)[1], convertirFecha(fecha)[2]);
    }
    public static int[] convertirFecha(String fecha) {
        String[] valores = fecha.split("-");
        int[] convertidos = new int[valores.length];
        for (int i = 0; i<valores.length; i++){
            convertidos[i] = Integer.parseInt(valores[i]);
        }
        return convertidos;
    }
    public int getDia(){
        return this.dia;
    }
    public int getMes(){
        return this.mes;
    }
    public int getAño(){
        return this.año;
    }
    public String toString(){
        return "La fecha es:" + getDia() + "-" + getMes() + "-" + getAño();
    }
    public int comparar(Fecha f2){
        if (this.igualA(f2)) return 0;
        if (this.mayorA(f2)) return 1;
        else return -1;
    }
    public boolean igualA(Fecha f2){
        return this.getDia() == f2.getDia() &&
            this.getMes() == f2.getMes() &&
            this.getAño() == f2.getAño() ? true : false;
    }
    public boolean menorA(Fecha f2){
        if (this.getAño() < f2.getAño()){
            return true;
        }else if (this.getAño() == f2.getAño() && this.getMes() < f2.getMes()){
            return true;
        }else if (this.getAño() == f2.getAño() && this.getMes() == f2.getMes() && this.getDia() < f2.getDia()){
            return true;
        }else {
            return false;
        }
    }
    public boolean mayorA(Fecha f2){
        if (this.getAño() > f2.getAño()){
            return true;
        }else if (this.getAño() == f2.getAño() && this.getMes() > f2.getMes()){
            return true;
        }else if (this.getAño() == f2.getAño() && this.getMes() == f2.getMes() && this.getDia() > f2.getDia()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args){
        String s = "12-09-1997";
        Fecha f1 = new Fecha(s);
        Fecha f2 = new Fecha(12, 9, 2020);
        System.out.println(f1.toString());
        System.out.println(f2.toString());
        System.out.println(f1.equals(f2)); 
        System.out.println(f1.menorA(f2));
        System.out.println(f1.mayorA(f2));
    }
}