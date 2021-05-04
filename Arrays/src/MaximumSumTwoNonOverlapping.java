import java.util.HashSet;
import java.util.Set;

public class MaximumSumTwoNonOverlapping {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {

        int sumL[] = new int[A.length];
        int sumM[] = new int[A.length];
        int maxLLeft[] = new int[A.length];
        int maxMLeft[] = new int[A.length];
        int maxLRight[] = new int[A.length];
        int maxMRight[] = new int[A.length];

        for(int i =0;i<L;i++)
            sumL[0] = sumL[0] + A[i];

        for(int i =0;i<M;i++)
            sumM[0] = sumM[0] + A[i];


        for(int i = 1;i<=A.length-L;i++){
            sumL[i] = sumL[i-1] - A[i-1] + A[i+L-1];

        }

        for(int i = 1;i<=A.length-M;i++){
            sumM[i] = sumM[i-1] - A[i-1] + A[i+M-1];

        }

        maxLLeft[0] = sumL[0];
        maxLRight[A.length-L] = sumL[A.length-L];
        maxMLeft[0] = sumM[0];
        maxMRight[A.length-M] = sumM[A.length-M];

        for(int i = 1;i<=A.length-L;i++)
            maxLLeft[i] = Integer.max(sumL[i],maxLLeft[i-1]);

        for(int i = A.length-L-1;i>=0;i--)
            maxLRight[i] = Integer.max(sumL[i],maxLRight[i+1]);

        for(int i = 1;i<=A.length-M;i++)
            maxMLeft[i] = Integer.max(sumM[i],maxMLeft[i-1]);

        for(int i = A.length-M-1;i>=0;i--)
            maxMRight[i] = Integer.max(sumM[i],maxMRight[i+1]);


        int total = 0;
        int maxValLeft = 0;
        int maxValRight = 0;
        for(int m=0;m<=sumL.length-L;m++){
            if(m-M>=0)
                maxValLeft = maxMLeft[m-M];
            else
                maxValLeft = 0;

            if(m+L<A.length)
                maxValRight = maxMRight[m+L];
            else
                maxValRight = 0;

            total = Integer.max(total,sumL[m]+Integer.max(maxValLeft,maxValRight));
        }

        for(int m=0;m<=sumL.length-M;m++){
            if(m-L>=0)
                maxValLeft = maxLLeft[m-L];
            else
                maxValLeft = 0;

            if(m+M<A.length)
                maxValRight = maxLRight[m+M];
            else
                maxValRight = 0;

            total = Integer.max(total,sumM[m]+Integer.max(maxValLeft,maxValRight));
        }

        return total;

    }

    public static void main(String[] args) {
        int arr[] = {8,20,6,2,20,17,6,3,20,8,12};
        System.out.println(new MaximumSumTwoNonOverlapping().maxSumTwoNoOverlap(arr,5,4));
    }
}
