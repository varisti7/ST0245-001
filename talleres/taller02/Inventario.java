public class Inventario {
    private int pesoMaximo;
    public static int[] accesorios;

    public Inventario(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }
    public int getPesoMaximo() {
        return this.pesoMaximo;
    }
    public boolean sumaGrupo(int start, int[] nums, int target) {
        if (start == nums.length) return target == 0;
        return sumaGrupo(start+1, nums, target - nums[start])
              ||sumaGrupo(start+1, nums, target);
    }
    public static void main(String[]args){
        Inventario i1 = new Inventario(10);
        i1.accesorios = new int[]{1,2,3,8,3};
        System.out.println(i1.sumaGrupo(0, i1.accesorios, 7));

    }
}