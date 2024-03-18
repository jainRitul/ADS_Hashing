import java.util.ArrayList;
import java.util.HashSet;

class IntersectionOfTwoArr{
    public static void main(String[] args) {
        int a[] = {10,10,10,15,45,3,4,5};
        int b[] = {10,10,10,4,3,9,77,10};
        // System.out.println( findIntersectionCount(a,b));
        // System.out.println( findIntersectionCountApproachTwo(a,b));
        System.out.println(findIntersectionCountEfficient(a, b));

    }
    static int findIntersectionCountEfficient(int a[],int b[]){
        HashSet<Integer>hs = new HashSet<>();
        int m = a.length;
        int n = b.length;
        for(int i = 0;i<m;i++){
            hs.add(a[i]);
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(hs.contains(b[i])){
                count++;
                hs.remove(b[i]);
            }
        }return count;
    }
    static int findIntersectionCountApproachTwo(int a[],int b[]){
        int n = a.length;
        int m = b.length;
        int res=0;
        for(int i=0;i<n;i++)
        {
            boolean flag  = false;
            for(int j=0;j<=i;j++){
                if(a[i] == a[j]){flag = true; break;}
            }
            if(flag == true) continue;
            for(int j=0;j<m;j++)
            {
                if(a[i] == b[j]) 
                {
                    res++;
                    break;
                }
            }
        }return res;
    }
    static int findIntersectionCount(int a[],int b[]){
        int n = a.length;
        int m = b.length;
        if(n > m) findIntersectionCount(b, a);

        ArrayList<Integer>ans = new ArrayList<>();
        for(int i=0;i<a.length;i++)
        {
            for(int j= 0;j<b.length;j++)
            {
                if(a[i] == b[j]  && ans.contains(a[i]) == false) {
                    ans.add(a[i]);
                }
            }
        }
        return ans.size();
    }
}