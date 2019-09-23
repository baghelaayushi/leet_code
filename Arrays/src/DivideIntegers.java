public class DivideIntegers {
    public int add(int x, int y){
        while(y!=0) {
            int carry = y & x;
            x = x ^ y;
            y = carry<<1;
        }
        return x;

    }
    public int divide(int A, int B) {
        int x = B;
        int count=0;
       while(x<A){
           x = add(x,B);
           count++;
       }
       return count;

    }
    public static void main(String args[]){
        DivideIntegers ob = new DivideIntegers();
        System.out.println(ob.divide(5,2));
    }
}
