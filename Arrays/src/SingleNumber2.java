public class SingleNumber2 {
    public int singleNumber(final int[] A) {
        String s = "";
        int i;
        for(i=0;i<=32;i++){
            int first_count = 0;
            int second_count =0;
            for(int j:A){
                int x = (j>>i) & 1;
                if(x==1)
                    first_count++;
                else
                    second_count++;

            }
            if(first_count%3 ==1)
                s+= "1";
            else if(second_count%3 == 1)
                s+="0";

            if(first_count == 1||second_count==1)
                break;

        }
        System.out.println(s);
        for(int j:A){
            int b =0;
            for(int k=0;k<s.length();k++){
                int x= (j>>k) & 1;
                if((x==1 && s.charAt(k)=='1')||(x==0 && s.charAt(k)=='0'))
                    b++;
            }
            if(b == s.length())
                return j;
        }

        return -1;

    }
    public static void main(String args[]){
        int A[] = {1,2,4,3,3,2,2,3,1,1};
        SingleNumber2 ob = new SingleNumber2();
        System.out.println(ob.singleNumber(A));
    }
}
