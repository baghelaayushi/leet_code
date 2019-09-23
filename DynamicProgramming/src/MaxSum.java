import java.util.Arrays;

public class MaxSum {
    public static int solve(int[] A, int B, int C, int D) {
        int sum =0;
        if(B>0)
            sum+= B * A[A.length-1];
        else
            sum+= B * A[1];

        if(C>0)
            sum+= C * A[A.length-1];
        else
            sum+= C * A[1];

        if(D>0)
            sum+= D * A[A.length-1];
        else
            sum+= D * A[1];

        return sum;
    }
    public static void main(String args[]){
        int A[] ={ -21, 34, 3, 46, 8, -47, -47 };
        Arrays.sort(A,1,A.length);
        System.out.println(solve(A,-13,10,9));
    }

}

