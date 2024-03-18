import java.util.ArrayList;
import java.util.HashSet;

class UnionOfTwoArr {
    public static void main(String[] args) {
        int a[] = {15,20,5,15};
        int b[] = {15,15,20,15,9,66};
        System.out.println(findUnionCount(a,b));
        System.out.println(findUnionCountNaive(a,b));
    }
    static int findUnionCountNaive(int a[],int b[]){
        int n = a.length;
        int m = b.length;

        ArrayList<Integer>arr = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            if(arr.contains(a[i]) == false)
              arr.add(a[i]);
        }
        for(int i=0;i<m;i++){
            if(arr.contains(b[i]) == false)
              arr.add(b[i]);
        }
        return arr.size();
    }
    static int findUnionCount(int a[],int b[]){
        int n = a.length;
        int m = b.length;
        HashSet<Integer>s = new HashSet<>();
        for(int i=0;i<n;i++){
            s.add(a[i]);
        }
        for(int j=0;j<m;j++){
            s.add(b[j]);
        }
        return s.size();
    }
}

