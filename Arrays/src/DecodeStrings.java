public class DecodeStrings {
    static int dp[];
    static String str;
    public int numDecodingsUtil(int start, int end){
        if(str.charAt(start) == '0')
            return 0;
        if(start == end)
            return 1;
        if(start - end == 1)
            if(Integer.valueOf(str.substring(start, end+1))>26)
                return numDecodingsUtil(start+1,end);
            else
                return 1+numDecodingsUtil(start+1,end);
        int sum1 = numDecodingsUtil(start+1,end);

        if(Integer.valueOf(str.substring(start,start+2))>26)
            return sum1;
        else
            return sum1+numDecodingsUtil(start+2,end);

    }
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')
            return 0;
         dp = new int[s.length()];
         str = s;
         return numDecodingsUtil(0,s.length()-1);
    }
    public static void main(String args[]){
        DecodeStrings ob = new DecodeStrings();
        System.out.println(ob.numDecodings("1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"));

    }
}
