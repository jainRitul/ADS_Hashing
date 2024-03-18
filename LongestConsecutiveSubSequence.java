import java.util.Arrays;
import java.util.HashSet;

class LongestConsecutiveSubSequence {
    public static void main(String[] args) {
        int arr[]  = {2,9,4,3,10,11,12,13,14};
        System.out.println(findLengthOfLongestConsecutiveSubsequence(arr));
        System.out.println(findLengthOfLongestConsecutiveSubsequenceEfficient(arr));
    }
    static int findLengthOfLongestConsecutiveSubsequenceEfficient(int arr[]){
        int n = arr.length;

        HashSet<Integer>s = new HashSet<>();
        for(int i = 0;i<n;i++)
            s.add(arr[i]);
        
      
        int res = 1;
        for(Integer x  : s)
        {
           if(s.contains(x-1) == false)
           {
                int curr = 1; 
                while(s.contains(x+curr))
                  curr++;
                
                res = Math.max(curr,res);
           }
        }return res;
    }
    static int findLengthOfLongestConsecutiveSubsequence(int arr[]){

        int n = arr.length;
        Arrays.sort(arr);
        int ans = 1;
        for(int  i = 1;i<n;i++){
           
            if(arr[i] == arr[i-1] +1){
                int count = 1;
                while(i< n && (arr[i] == arr[i-1] +1)){
                    count++;
                    i++;
                }
                ans = Math.max(count,ans);
            }
        }return ans;
    }
}
