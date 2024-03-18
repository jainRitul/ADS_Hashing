import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class MoreThanNByKOccurencesForHigherValueOfN {
    public static void main(String[] args) {
        int arr[]  = {30,10,20,20,20,10,40,30,30};
        int k = 4;
        moreThanNByKOucc(arr,k);
    }
    static void moreThanNByKOucc(int arr[],int k){
        int n =arr.length;
        HashMap<Integer,Integer>hm = new HashMap<>();

        for(int i = 0;i<n;i++){
            if(hm.containsKey(arr[i])){
                hm.put(arr[i],hm.get(arr[i])+1);
            }
            else if(hm.size() < k-1){
                hm.put(arr[i] , 1);
            }
            else{
                for(Entry<Integer, Integer> e : hm.entrySet()){

                      if(e.getValue() == 1) hm.remove(e);
                      if(e.getValue()> 1 ) hm.put(e.getKey() , e.getValue()-1);
                }
            }
        }
        for(Entry<Integer, Integer> e : hm.entrySet()){
            int x = e.getKey();
            int count = 0;
            for(int i = 0;i<n;i++){
                if(arr[i] == x) count++;
            }
            if(count > n/k) System.out.print(x+" ");
        }
        
        
    }
}
