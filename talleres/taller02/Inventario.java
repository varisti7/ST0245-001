public class Inventario {
    public static int[] accesorios;

    public Inventario() {
    }
    public boolean sumaGrupo(int start, int[] nums, int target) {
        if (start == nums.length) return target == 0;
        return sumaGrupo(start+1, nums, target - nums[start])
              ||sumaGrupo(start+1, nums, target);
    }
}