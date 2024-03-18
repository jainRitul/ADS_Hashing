import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class MoreThanNDIvideByKOccurences {
    public static void main(String[] args) {
        int arr[]  = {30,10,20,20,10,20,30,30};
        int k =6;
        moreThanNBykOccurences(arr,k);
        moreThanNBykOccurencesSorting(arr,k);
    }
    static void moreThanNBykOccurencesSorting(int arr[],int k ){
        Arrays.sort(arr);
        int n = arr.length;

        int i =1;
        int count  = 1;
        while(i < n){
            while(i<n && arr[i] == arr[i-1]){
                count++;
                i++;
            }
            if(count > n/k){
                System.out.print(arr[i-1]  + " ");
            }
            count = 1;
            i++;
        }
    }
    static void moreThanNBykOccurences(int arr[],int k){
        int n = arr.length;

        HashMap<Integer,Integer>hm = new HashMap<>();
        for(int i = 0;i<n;i++){
            hm.put(arr[i] , hm.getOrDefault(arr[i] , 0 ) +1);
           
        }
        for(Entry<Integer, Integer> e : hm.entrySet()){
            if(e.getValue() > n/k){
                System.out.print(e.getKey() + " ");
            }
        }System.out.println();
    }
}
