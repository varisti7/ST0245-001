public class MergeSort {
    public static void mergeList(int [] list){
        for(int mergeSize = 1; mergeSize < list.length; mergeSize*=2){
            for(int startingPoint = 0; startingPoint < list.length; startingPoint += mergeSize*2){
                int middlePoint = Math.min(startingPoint + mergeSize - 1, list.length - 1); 
                int endingPoint = Math.min(startingPoint + 2 * mergeSize - 1, list.length - 1); 
                int lengthArrayLeft = middlePoint - startingPoint + 1; 
                int lengthArrayRight = endingPoint - middlePoint; 
                int[] leftArray = new int[lengthArrayLeft];
                int[] rightArray = new int[lengthArrayRight];
                for (int i = 0; i < lengthArrayLeft; i++) 
                    leftArray[i] = list[startingPoint + i]; 
                for (int j = 0; j < lengthArrayRight; j++) 
                    rightArray[j] = list[middlePoint + 1 + j];
                int i = 0, j = 0;
                int k = startingPoint; 
                while (i < lengthArrayLeft && j < lengthArrayRight){ 
                    if (leftArray[i] <= rightArray[j]){ 
                        list[k] = leftArray[i]; 
                        i++; 
                    } 
                    else{ 
                        list[k] = rightArray[j]; 
                        j++; 
                    } 
                    k++; 
                }
                while(i < lengthArrayLeft){ 
                    list[k] = leftArray[i]; 
                    i++; 
                    k++; 
                } 
                while (j < lengthArrayRight) { 
                    list[k] = rightArray[j]; 
                    j++; 
                    k++; 
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
        for(int i = 1000; i < 524288001; i*=2){
            int[] list = getArray(i);
            long t1 = System.currentTimeMillis();
            mergeList(list);
            System.out.println(System.currentTimeMillis() - t1);
        }
    }
}