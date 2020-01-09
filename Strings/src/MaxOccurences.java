import java.util.HashMap;
import java.util.Map;

public class MaxOccurences {
    public int maxFreqUtil(String s, int maxLetters, int size) {
        int n = s.length()%size;
        int charArr[] = new int[26];
        int start = 0, end =0, count =1;
        charArr[s.charAt(end)-97]++;
        HashMap<String,Integer> hm = new HashMap<>();

        while(end<s.length()){
            if(end - start == size -1){
                if(count<=maxLetters){
                    if(!hm.containsKey(s.substring(start,end+1)))
                        hm.put(s.substring(start,end+1),1);
                    else {
                        int x = hm.get(s.substring(start,end+1));
                        hm.replace(s.substring(start,end+1),x+1);
                    }
                }
                int x = charArr[s.charAt(start)-97];
                if(x==1){
                    count--;
                }
                charArr[s.charAt(start)-97]--;
                start = start+1;
            }
            else {
                ++end;
                if(end<s.length()) {
                    if (charArr[s.charAt(end) - 97] == 0)
                        count++;
                    charArr[s.charAt(end) - 97]++;
                }

            }
        }
        int max = Integer.MIN_VALUE;
        for(Map.Entry<String,Integer> m: hm.entrySet())
            max = Math.max(m.getValue(),max);

        return max;

    }
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int globalMax = 0;
        for(int i = minSize; i<= maxSize;i++)
            globalMax = Math.max(maxFreqUtil(s,maxLetters,i),globalMax);

        return globalMax;

    }

    public static void main(String[] args) {
        String s = "aababcaab";
        MaxOccurences ob = new MaxOccurences();
        System.out.println(ob.maxFreq(s,2,3,4));
    }
}
