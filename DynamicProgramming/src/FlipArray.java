import java.util.Arrays;

public class FlipArray {
    public static int solve(final int[] A) {
        int sum =0;
        for(int i:A)
            sum+= i;
        System.out.println(sum);

        int temp=Integer.MAX_VALUE;
        int i;
        int first =0;
        for(i=0;i<A.length;i++){
            first += -A[i];
            int second = sum - (-first);
            System.out.println(first + "  " + second);
            int total = first +second;
            if(total<0) {
                if (-total < temp)
                    temp = -total;
                else{
                    break;
                }
            }
            if(total>=0){
                if(total<temp)
                    temp = total;
                else
                    break;
            }
        }
        return Integer.min(A.length-i,i);
    }
    public static void main(String args[]){
        int A[] = {2,4,2 };
        System.out.println(solve(A));
    }
}
