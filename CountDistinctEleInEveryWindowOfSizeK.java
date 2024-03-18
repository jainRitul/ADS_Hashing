import java.util.HashMap;
import java.util.HashSet;

class CountDistinctEleInEveryWindowOfSizeK {
    public static void main(String[] args) {
        int arr[] = {10,20,10,10,30};
        int k = 4;
        countDistinctInEachWindow(arr,k);
        System.out.println();
        countDistinctInEachWindowEfficient(arr,k);
    }
    static void countDistinctInEachWindowEfficient(int arr[],int k){
       int n = arr.length;
       int distinctCount = 0;
       HashMap<Integer,Integer>hm = new HashMap<>();
       for(int i = 0;i<k;i++){
           hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
           if(hm.get(arr[i]) == 1) 
            distinctCount++;
       }
       System.out.println(distinctCount);

       for(int i = k;i<n;i++){
           hm.put(arr[i] , hm.getOrDefault(arr[i] , 0 ) +1);

           if(hm.get(arr[i]) == 1) distinctCount++;

           hm.put(arr[i-k] , hm.getOrDefault(arr[i-k] , 0) -1);
           if(hm.get(arr[i-k]) == 0) distinctCount--;

           System.out.println(distinctCount);
       }
    }
    static void countDistinctInEachWindow(int arr[],int k){
        int n = arr.length;
        HashSet<Integer>s = new HashSet<>();
        
        for(int i = 0;i<n -k +1;i++)
        {   
            int j = i;
            while(j<k+i && j < n)
            {
                s.add(arr[j]);
                j++;
            }
            
            System.out.println(s.size());
            
           s.clear();
           
        }
    }
}
