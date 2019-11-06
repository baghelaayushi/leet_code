import java.util.HashMap;

public class minimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<t.length();i++){
            hm.put((int)s.charAt(i),Integer.MIN_VALUE);
        }
        int count =0;
        int min=0;
        int max = 0;
        int global_min =0;
        int global_max =0;
        for(int i=0;i< s.length();i++) {
            if (hm.containsKey((int) s.charAt(i))) {
                if (hm.get((int) s.charAt(i)) == Integer.MIN_VALUE) {
                    count++;
                    hm.replace(((int) s.charAt(i)), i);
                }
                if (count == 3)
                    break;
            }
        }
        return "";
    }
    public static void main(String args[]){
        minimumWindowSubstring ob = new minimumWindowSubstring();
        System.out.println(ob.minWindow("",""));
    }
}
