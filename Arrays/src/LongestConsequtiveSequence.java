import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestConsequtiveSequence {
    public static int longestConsecutive(final int[] A) {
        HashMap<Integer, Integer> hm=new HashMap<Integer,Integer>();
        hm.put(A[0],1);
        for(int i=1;i<A.length;i++){
            if(!hm.containsKey(A[i])) {
                hm.put(A[i], 1);
                if (hm.containsKey(A[i] - 1)) {
                    hm.replace(A[i], hm.get(A[i] - 1) + hm.get(A[i]));
                }
                if (hm.containsKey(A[i] + 1)) {
                    hm.replace(A[i], hm.get(A[i] + 1) + hm.get(A[i]));
                }
                int x = hm.get(A[i]);
                if (hm.containsKey(A[i] - 1)) {
                    int j = hm.get(A[i] - 1);
                    hm.replace(A[i] - j,x);
                }
                if (hm.containsKey(A[i] + 1)) {
                    int j = hm.get(A[i] + 1);
                    hm.replace(A[i] + j, x);
                }
            }
        }
        int max= 0;
        for(Map.Entry<Integer, Integer> m:hm.entrySet()){
            if(m.getValue() > max)
                max = m.getValue();
        }

        return max;
    }
    public static void main(String []args){
        int A[] = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        System.out.println(longestConsecutive(A));
    }
}
