public class StringCompression {
    public int compress(char[] chars) {
        int count =1;
        char last_char = chars[0];
        for(int i=1;i<chars.length;i++){
            if(chars[i] == chars[i-1]|| chars[i] == last_char){
                char c = String.valueOf((++count)%10).charAt(0) ;
                chars[i] = c;
            }
            else{
                last_char = chars[i];
                count =1;
            }

        }
        for(int i =0;i<chars.length-1;i++){
            if(chars[i+1]=='2'){
                while(i<chars.length-1 && !((int)chars[i+1]>=97 || (int)chars[i+1]<=122)){

                }
            }
        }
        for(char c:chars)
            System.out.println(c);
        return 0;
    }
    public static void main(String args[]){
        char chars[] = {'a','a','a','b','b','b','c','c'};
        StringCompression ob = new StringCompression();
        ob.compress(chars);
    }
}
