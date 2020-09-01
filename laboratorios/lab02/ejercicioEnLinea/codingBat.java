public class codingBat{
    // Array 2

    // Array-2 > countEvens 
    public int countEvens(int[] nums) {
        int cont = 0;
        for (int i = 0; i<nums.length; i++){
          if(nums[i] % 2 == 0) cont ++;
        }
        return cont;
    }

    //   Array-2 > bigDiff 
    public int bigDiff(int[] nums) {
        int max = nums[0], min = nums[0];
        for (int i = 0;i < nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        return max - min;
    }

    // Array-2 > sum13 
    public int sum13(int[] nums) {
        int cont = 0;
        if(nums.length == 0) return 0;
        else{
          for(int i = 0; i < nums.length; i++){
            if(i + 1 < nums.length && nums[i] == 13) i++;
            else if(nums[i] != 13) cont+= nums[i];
          }
          return cont;
        }
    }

    // Array-2 > sum67 
    public int sum67(int[] nums) {
        boolean six = false;
        int cont = 0;
        if(nums.length == 0) return 0;
        else{
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 6) six = true;
                else if(six == true && nums[i] == 7) six = false;
                else if(six == false) cont+= nums[i];
            }
            return cont;
        }
    }

    // Array-2 > has22 
    public boolean has22(int[] nums) {
        boolean yes = false;
        for(int i = 0; i < nums.length; i++){
          if(i + 1 < nums.length && nums[i] == 2 && nums[i + 1] == 2) yes = true;
        }
        return yes;
    }

     // Array 3

    //  Array-3 > fix34 
    public int[] fix34(int[] nums) {
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
          if(nums[i] == 3){
            temp = nums[i + 1];
            for(int j = 0; j < nums.length; j++){
              if(nums[j] == 4 && nums[j - 1] != 3){
                nums[i + 1] = 4;
                nums[j] = temp;
                break;
              }
            }
          }
        }
        return nums;
    }

    // Array-3 > fix45 
    public int[] fix45(int[] nums) {
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
          if(nums[i] == 4){
            temp = nums[i + 1];
            for(int j = 0; j < nums.length; j++){
              if((j - 1 >= 0 && nums[j] == 5 && nums[j - 1] != 4) || nums[0] == 5){
                nums[i + 1] = 5;
                nums[j] = temp;
                break;
              }
            }
          }
        }
        return nums;
    }

    // Array-3 > canBalance 
    public boolean canBalance(int[] nums) {
        int sum1 = 0, sum2 = 0;
        boolean yes = false;
        for(int i = 0; i < nums.length; i++){
          sum1 += nums[i];
          for(int j = i + 1; j < nums.length; j++){
            sum2 += nums[j];
          }
          if(sum1 == sum2) yes = true;
          sum2 = 0;
        }
        return yes;
    }      

    // Array-3 > squareUp 
    public int[] squareUp(int n) {
        int[] nums = new int[n*n];
        int cont = 0;
        for(int i = 0; i < nums.length; i++){
          if(i % n == 0) cont++;
          if(n - i % n <= cont) {
            nums[i] = n - i%n;
          }
        }
        return nums;
    }

    // Array-3 > seriesUp 
    public int[] seriesUp(int n) {
        int[] nums = new int[n*(n + 1) / 2];
        int cont = 0;
        for(int i = 0; i < n; i++){
          for(int j = 0; j <= i; j++){
            nums[cont] = j + 1;
            cont++;
          }
        }
        return nums;
    }
}