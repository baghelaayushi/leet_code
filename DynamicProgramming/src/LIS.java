import java.util.Arrays;
import java.util.Collections;

public class LIS {
    public static int lis(final int[] A) {
        int arr[] = new int[A.length];
        arr[0] = 1;
        for(int i =1;i<A.length;i++) {
            int min = 0;
            for (int j =0;j<i;j++){
                if(A[j]<A[i]&& arr[j]>min)
                    min = arr[j];
            }
            arr[i] = min+1;
        }

        int max =0;
        for(int i:arr)
            if(i>max)
                max =i;

        return max;
    }
    public static void main(String[]  args){
        int A[] = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(lis(A));
    }
}
