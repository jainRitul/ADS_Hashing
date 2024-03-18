import java.util.Arrays;
import java.util.HashSet;

class PairWithGivenSum {
    public static void main(String[] args) {
        int arr[] = {5,5,12,10};
        int sum = 15;
        System.out.println(checkPairWithGivenSum(arr,sum));
        System.out.println(checkPairWithGivenSumEfficient(arr,sum));
        System.out.println(checkPairWithGivenSumEfficientHashSet(arr,sum));
    }
    static boolean checkPairWithGivenSumEfficientHashSet(int arr[],int sum){
        int n = arr.length;
        HashSet<Integer>s = new HashSet<>();
        for(int i=0;i<n;i++){
            if(s.contains(sum - arr[i])){
                return true;
            }
            else s.add(arr[i]);
        }
        return false;
    }
    static boolean checkPairWithGivenSumEfficient(int arr[],int sum){
        int n = arr.length;
        if(n==1) return false;
       
        Arrays.sort(arr);
        int low = 0;
        int high = n-1;
        while(low < high){
            if(arr[low] + arr[high] == sum) return true;
            else if(arr[low] + arr[high] > sum ) high--;
            else low++;
        }
        return false;
    }
    static boolean checkPairWithGivenSum(int arr[],int sum)
    {
        int n =arr.length;

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++){
                if(i==j) continue;

                if(arr[i] + arr[j] == sum) return true;
            }
        }return false;
    }
}
