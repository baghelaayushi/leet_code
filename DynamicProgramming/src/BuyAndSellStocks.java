public class BuyAndSellStocks {
    public static int maxProfit(final int[] A) {
        // this method uses O(n^2)time
        /*int global_max =0;
        int min = A[0];
        int max = A[0];
        for(int i=0;i<A.length;i++){
            int max1 = 0;
            for(int j=0;j<=i;j++)
                if(A[i]-A[j]>max)
                    max1 = A[i]-A[j];
            if(max1>global_max)
                global_max = max1;
        }

        return global_max;*/
        int min[] = new int[A.length];
        int minimum = A[0];
        min[0] = A[0];
        for(int i = 0;i<A.length;i++){
            if(A[i]<minimum) {
                minimum = A[i];
                min[i] = A[i];
            }
            else
                min[i] = minimum;
        }

        int max =0;
        for(int i=0;i<A.length;i++)
            if(A[i]-min[i]>max)
                max = A[i] - min[i];

        return max;
    }
    public static void main(String args[]){
        int A[] ={1, 4, 5, 2, 4};
        System.out.println(maxProfit(A));
    }
}
