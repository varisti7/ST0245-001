public class InsertionSort {
    public static void sortList(int [] list){
        for(int i = 1; i < list.length; i++){
            for(int j = i; j > 0; j--){
                if(list[j] < list[j - 1]){
                    int aux = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = aux;
                }
            }
        }
    }
    public static int[] getArray(int n) {
        int arr[] = new int[n];
        int m = n;
        for(int i = 0; i < m; i++){
            arr[i] = n;
            n--;
        }
        return arr;
    }
    public static void main(String[] args){
        for(int i = 10000; i < 210000; i+=10000){
            int[] list = getArray(i);
            long t1 = System.currentTimeMillis();
            sortList(list);
            System.out.println(System.currentTimeMillis() - t1);
        }
    }
}