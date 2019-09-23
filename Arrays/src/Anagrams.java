import java.util.*;

public class Anagrams {
    static int[][] anagrams(final String[] A) {
        HashMap<Integer, List<Integer>> hm=new HashMap<Integer,List<Integer>>();
        int k =0;
        for(String s:A){
            int sum = 0;
            for(int i=0;i<s.length();i++){
                sum = sum + s.charAt(i);
            }
            if(hm.containsKey(sum)) {
                hm.get(sum).add(k);
            }
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(k);
                hm.put(sum,temp);
            }
            k++;
            //System.out.println(sum);
        }

        List<List<Integer>> lst = new ArrayList<>();

        for(Map.Entry<Integer, List<Integer>> m:hm.entrySet()){
            int unique = 0;
            HashMap<Integer, List<Integer>> hmn=new HashMap<Integer,List<Integer>>();
            List<Integer> temp = m.getValue();
            //System.out.println(temp);
            for(int i=0;i<temp.size();i++) {
                int count[] = new int[26];
                unique = 0;
                String str = A[temp.get(i)];
                for (k = 0; k < str.length(); k++) {
                    if (count[str.charAt(k) - 97] == 0) {
                        unique++;
                    }
                    count[str.charAt(k)-97]++;
                }
                System.out.println(unique);
                if(hmn.containsKey(unique)) {
                    hmn.get(unique).add(temp.get(i));
                }
                else {
                    List<Integer> temp2 = new ArrayList<>();
                    temp2.add(temp.get(i));
                    hmn.put(unique,temp2);
                }
            }
            for(Map.Entry<Integer, List<Integer>> mn:hmn.entrySet())
                lst.add(mn.getValue());
        }
        //System.out.println(lst);

        int output[][] =new int[lst.size()][];

        for(int m =0; m<lst.size();m++){
            output[m] = new int[lst.get(m).size()];
            for(int n=0; n<lst.get(m).size();n++){
                output[m][n] = lst.get(m).get(n)+1;
            }
        }
        return output;

    }
    public static void main(String []args){
        String []A = { "caat", "taac", "dog", "god", "acta" };
        int v[][] = anagrams(A);
        for(int[]x:v) {
            for (int i : x)
                System.out.print(i + " ");
         System.out.println();
        }
    }
}
