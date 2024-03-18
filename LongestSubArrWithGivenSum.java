import java.util.HashMap;

class LongestSubArrWithGivenSum {
    public static void main(String[] args) {
        int arr[] = {5,2,3};
        // System.out.println(findLengthOfLongestSubArr(arr,0));

        System.out.println(findLengthOfLongestSubArrEfficient(arr,5));
    }
    static int findLengthOfLongestSubArrEfficient(int arr[],int givenSum){
        int n = arr.length;

        int ans = 0;
        int pSum = 0;
        HashMap<Integer,Integer>hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            pSum += arr[i];
            
            if (pSum == givenSum) {
                ans = i + 1; // Update ans when the current prefix sum equals givenSum
            }
    
            if (!hm.containsKey(pSum)) {
                hm.put(pSum, i);
            }
    
            if (hm.containsKey(pSum - givenSum)) {
                if(ans < (i - hm.get(pSum - givenSum))){
                    ans = i - hm.get(pSum - givenSum);
                }
            }
        }
        return ans;
    }














    static int findLengthOfLongestSubArr(int arr[],int givenSum){
        int n = arr.length;
        int ans =-1;
        for(int i = 0;i<n;i++){
            int sum = 0;
            for(int j = i;j<n;j++){
                sum += arr[j];
                if(sum == givenSum){
                    ans = Math.max(ans,j-i+1);
                }
                
            }
        }return ans;
    }

}
