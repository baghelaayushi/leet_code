public class ReverseBits {
    public long reverse(long a) {
        long rev =0;
        int size = Long.toBinaryString(a).length();
        //System.out.println(size);
        while(a>0){
            rev<<=1;
            if((a&1)==1)
                rev^= 1;
            a>>=1;
        }
        size = 32-size;
        rev<<=size;
        return rev;
    }
    public static void main(String args[]){
        ReverseBits ob = new ReverseBits();
        System.out.println(ob.reverse(3));
    }
}
