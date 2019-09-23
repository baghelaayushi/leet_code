import java.util.HashSet;

public class CoinSum {
    static int count =0;
    static HashSet<Integer> hs = new HashSet<>();
    public static void coinchange2Util(int[] A, int B){

        if(B==0){
            count++;
            return;
        }
        if(B<0)
            return;

        hs.add(B);

        for(int i:A) {
            coinchange2Util(A, B - i);
        }

    }
    public static int coinchange2(int[] A, int B) {
        count =0;
        hs = new HashSet<>();
        coinchange2Util(A,B);
        return count;
    }
    public static void main(String args[]){
        int A[] = {1,2,3};
        System.out.println(coinchange2(A,4));
    }
}
