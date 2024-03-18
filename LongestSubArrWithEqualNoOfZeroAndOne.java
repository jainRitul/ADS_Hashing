import java.util.HashMap;

class LongestSubArrWithEqualNoOfZeroAndOne {
    public static void main(String[] args) {
        int arr[] = {0,0,0,0,1,1,0};
        System.out.println(findLengthNaive(arr));
        System.out.println(findLengthEfficient(arr));
    }
    static int findLengthEfficient(int arr[]){
        int n = arr.length;

        for(int i =0;i<n;i++)
         if(arr[i] == 0) arr[i] = -1;

        int pSum = 0;
        int ans = 0;
        HashMap<Integer,Integer>hm = new HashMap<>();
        for(int i = 0;i<n;i++)
        {    
            pSum += arr[i];
            if(pSum  == 0) ans = i+1; 

            if(hm.containsKey(pSum +n))
                ans = Math.max(ans,i - hm.get(pSum +n)); 
            else 
                hm.put(pSum+n,i);

           
         
        }return ans;
        
    }
    static int findLengthNaive(int arr[]){
        int ans = 0;
        int n = arr.length;
        int count1 = 0;
        int count0 = 0;

        for(int i = 0;i<n;i++){
            count0 = 0;
            count1 = 0;
        
            for(int j = i;j<n;j++){
               if(arr[j] == 0) count0++;
               if(arr[j] == 1) count1++;

               if(count0 == count1) ans = Math.max(ans,count0 + count1);
            }
        }return ans;
    }
}
