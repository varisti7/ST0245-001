import java.util.ArrayList;

public class Permutaciones {
    public ArrayList<String> lista = new ArrayList<String>();

    public void permutation(String palabra){
        permutationAux("", palabra, this.lista);
    }
    private void permutationAux(String prefix, String str, ArrayList<String> lista) {
        int n = str.length();
        if (n == 0)
            anadirLista(prefix);
        else {
            for (int i = 0; i < n; i++)
            permutationAux(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), lista);
        }
        }
    public void anadirLista(String palabra) {
        this.lista.add(palabra);
    }
    public static void main(String[] args) {
        Permutaciones p1 = new Permutaciones();
        p1.permutation("abcd");
        for (String s: p1.lista){
            System.out.println(s);
        }
        for (String password: p1.lista){
            System.out.println(AdvancedEncryptionStandard.desencriptarArchivo(password));
        }
    }
}