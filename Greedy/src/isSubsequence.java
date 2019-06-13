public class isSubsequence {
    // the function returns true is a sub sequence is present using character arrays
    static boolean findSubsequence(char[] s, char[] t){
        int sStart = 0;
        int tStart = 0;

        // loops over the character arrays
        // if value is same for an index in both string, both indexes are incremented by one
        // else only index of longer string incremented
        while(tStart < t.length && sStart < s.length){
            if(s[sStart] != t[tStart])
                tStart ++;
            else{
                sStart++;
                tStart++;
            }
        }
        return sStart == s.length;
    }
    public static void main(String[] args){
        String s = "abc";
        String t = "ahgdc";
        char u[] = s.toCharArray();
        char v[] = t.toCharArray();
        System.out.println(findSubsequence(u,v));
    }

}
