import java.util.HashSet;

class SubarrWithGivenSum {
    public static void main(String[] args) {
        int arr[]  = {5,8,6,13,3,-1};
        int sum = 22;
        System.out.println(checkSubarrWithGivenSum(arr,sum));
        System.out.println(checkSubarrWithGivenSumEfficient(arr,sum));
    }
    static boolean checkSubarrWithGivenSumEfficient(int arr[],int sum){
        int n = arr.length;

        HashSet<Integer>hs = new HashSet<>();

        int pSum = 0;

        for(int i = 0;i<n;i++){
            pSum += arr[i];
            if(pSum == sum) return true;
            if(hs.contains(pSum  - sum)){
                return true;
            }
            hs.add(pSum);
        }return false;
    }
    static boolean checkSubarrWithGivenSum(int arr[],int givenSum){
        int n = arr.length;
      
        for(int i=0;i<n;i++){
            int sum =0;
            for(int j=i;j<n;j++){
               sum += arr[j];

               if(sum == givenSum){
                return true;
               }
            }
        }return false;
    }
}
