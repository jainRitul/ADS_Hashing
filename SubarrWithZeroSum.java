import java.util.HashSet;

class SubarrWithZeroSum {
    public static void main(String[] args) {
        int arr[] = {-3,2};
        System.out.println(checkSubarrWithZeroSumNaive(arr));
        System.out.println(checkSubarrWithZeroSumeEfficient(arr));
    }
    static boolean checkSubarrWithZeroSumeEfficient(int arr[]){
        int n = arr.length;
        HashSet<Integer>s = new HashSet<>();
        s.add(0);
        int pSum = 0;
        for(int i= 0;i<n;i++){
            pSum += arr[i];
            if(s.contains(pSum)) return true;
            
            s.add(pSum);
            
        }
        return false;

    }
    static boolean checkSubarrWithZeroSumNaive(int arr[])
    {
         int n = arr.length;
         for(int i=0;i<n;i++)
         {
            int sum = 0;
            
            for(int j = i;j<n;j++){
              
               sum += arr[j];
               if(sum == 0) return true;
            }
            if(sum == 0) return true;
        }return false;
         
    }
}
