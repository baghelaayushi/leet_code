import java.util.Arrays;

public class MinJumps {
    static int arr[];
    static int A[];
    public static int jumpUtil( int index){
        if(index == A.length-1)
            return 1;

        if(index>=A.length||A[index]==0)
            return 0;

        if(arr[index]!= 0)
            return arr[index]+1;


        int min = Integer.MAX_VALUE;
        for(int j=1;j<=A[index];j++){
            int val = jumpUtil(index+j);
            if(val<min && val!=0)
                min = val;

            if(min == Integer.MAX_VALUE)
                arr[index] = 0;
            else
                arr[index] = min;
        }

        if(min==Integer.MAX_VALUE)
            return 0;

        return min+1;

    }
    public static int jump(int[] x) {
        arr = new int[x.length];
        A = x;
        //Arrays.fill(arr,Integer.MAX_VALUE);
        jumpUtil(0);
        return arr[0];
    }
    public static void main(String args[]){
        int A[] = { 2,3,1,1,4};
        System.out.println(jump(A));
    }
}
