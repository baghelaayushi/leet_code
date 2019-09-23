import java.util.ArrayList;
import java.util.List;

public class TrappingRainWater {
    public int trap(final int[] A) {
        if(A.length ==0)
            return 0;
        int n = A.length;
        int left[] = new int[n],right[]= new int[n],sum=0;
        left[0] = A[0];
        right[n-1] = A[n-1];
        for(int i=1;i<n;i++)
            left[i] = Integer.max(left[i-1],A[i]);

        for(int i=n-2;i>=0;i--)
            right[i] = Integer.max(right[i+1],A[i]);

        for(int i =0;i<n;i++)
            sum+= Integer.min(left[i],right[i])-A[i];

        return sum;

    }

    public static void main(String args[]){
        TrappingRainWater ob = new TrappingRainWater();
        int A[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.print(ob.trap(A));
    }

}
