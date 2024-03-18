import java.util.HashMap;

class LongestCommonSubarrWithGivenSum {
    public static void main(String[] args) {
        int a[] = {0,1,0,0,0,0};
        int b[] = {1,0,1,0,0,1};

        System.out.println(longestSubarrWithSameSum(a,b));
        System.out.println(longestSubarrWithSameSumEfficient(a,b));
    }
    static int longestSubarrWithSameSumEfficient(int a[],int b[])
    {
          int n  = a.length;
          int temp[] = new int[n];
          int ans = 0;
          for(int i = 0;i<n;i++)
            temp[i] = a[i] - b[i];

          HashMap<Integer,Integer>hm = new HashMap<>();
          int pSum = 0;

          for(int i = 0;i<n;i++){
              pSum += temp[i];

              if(pSum == 0){
                 ans = i+1;
              }
              if(hm.containsKey(pSum)) {
                ans = Math.max(ans, i - hm.get(pSum));
              }else hm.put(pSum  ,i );
          }   
          return ans;
    }
    static int longestSubarrWithSameSum(int a[],int b[]){
        int n = a.length;
      
        int ans = 0;
        for(int i = 0;i<n;i++){
           int  s1 = 0;
           int s2 = 0;
            for(int j = i;j<n;j++){
               s1 += a[j];
               s2 += b[j];

               if(s1 == s2) ans = Math.max(ans, j - i +1);
            }
        }return ans;
    }
}
