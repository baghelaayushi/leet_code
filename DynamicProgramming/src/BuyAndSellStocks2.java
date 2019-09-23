public class BuyAndSellStocks2 {
    public static int maxProfit(final int[] A) {
        int min[] = new int[A.length];
        int minimum = A[0];
        min[0] = A[0];
        for(int i = 0;i<A.length;i++){
            if(A[i]<minimum) {
                minimum = A[i];
                min[i] = A[i];
            }
            else
                min[i] = A[i];
        }

        int max[] = new int[A.length];
        int maximum =A[A.length-1];
        max[A.length-1] =A[A.length-1];
        for(int i = A.length-1;i>=0;i--){
            if(A[i]>maximum) {
                maximum = A[i];
                max[i] = A[i];
            }
            else
                max[i] = maximum;
        }

        int sum =0;
        for(int i=0;i<A.length;i++)
            sum+= max[i]-min[i];

        return sum;
    }
    public static void main(String args[]){
        int A[] ={5,2,10};
        System.out.println(maxProfit(A));
    }
}
