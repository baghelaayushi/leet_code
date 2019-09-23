import java.util.Arrays;

public class MinXOR {
    public int findMinXor(int[] A) {
        Arrays.sort(A);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<A.length-1;i++) {
            int x = A[i]^ A[i+1];
            if (x < min)
                min = x;
        }
        return min;
    }
    public static void main(String args[]){
        int []A ={0,4,7,9};
        MinXOR ob = new MinXOR();
        System.out.println(ob.findMinXor(A));
    }
}
