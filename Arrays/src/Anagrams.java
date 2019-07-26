import java.util.*;

public class Anagrams {
    static int[][] anagrams(final String[] A) {
        HashMap<Integer, List<Integer>> hm=new HashMap<Integer,List<Integer>>();
        int k =0;
        int arr[][] = new int[A.length][26];
        for(String s:A){
            int sum = 0;
            for(int i=0;i<s.length();i++){
                arr[k][s.charAt(i)-97]++;
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
            System.out.println(sum);
        }

        List<List<Integer>> lst = new ArrayList<>();

        for(Map.Entry<Integer, List<Integer>> m:hm.entrySet()){
            if(m.getValue().size()>1){
                for(int l: m.getValue());
            }
            else
                lst.add(m.getValue());
        }
        System.out.println(lst);

        int output[][] =new int[lst.size()][];

        for(int m =0; m<lst.size();m++){
            output[m] = new int[lst.get(m).size()];
            for(int n=0; n<lst.get(m).size();n++){
                output[m][n] = lst.get(m).get(n);
            }
        }



        return output;

    }
    public static void main(String []args){
        String []A = { "cde", "bee"};
        int v[][] = anagrams(A);
        for(int[]x:v) {
            for (int i : x)
                System.out.print(i + " ");
         System.out.println();
        }
    }
}
