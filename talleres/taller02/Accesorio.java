public class Accesorio {
    private String tipo;
    private int peso;
    
    public Accesorio(String tipo, int peso){
        this.tipo = tipo;
        this.peso = peso;
    }
    public String getTipo() {
        return this.tipo;
    }
    public int getPeso() {
        return this.peso;
    }
}   