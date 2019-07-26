import java.util.HashMap;
import java.util.List;
import java.util.Map;

// this class contains a method that returns the length of longest substring
// of a string with distinct characters
public class SubstringWithoutRepeat {
    public static int lengthOfLongestSubstring(String A) {
        int i=0, j=1;
        HashMap<Integer, Integer> hm=new HashMap<Integer,Integer>();
        hm.put((int)A.charAt(0),0);
        if(A.length() == 1)
            return 1;
        int max=1;
        while(j<A.length()){
            int x= A.charAt(j);
            if(j-i > max)
                max = j-i;

            //System.out.println(j-i);
            if(hm.containsKey(x)){
                //System.out.println(j);
                if(hm.get(x)+1>=i)
                    i = hm.get(x)+1;
                hm.replace(x,j);
            }
            else
                hm.put(x,j);

            j++;
        }
        if(j-i > max)
            max = j - i;

        return max;
    }

    public static void main(String[] arg){
          System.out.println(lengthOfLongestSubstring("bbb"));
    }
}
