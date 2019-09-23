public class MaximumMinimumDifference {
    public int solve(int[] A, int B) {
        int min_increasing = Integer.MAX_VALUE;
        int max_increasing = Integer.MIN_VALUE;
        for(int i:A) {
            if (i - B < min_increasing && i-B > 0)
                min_increasing = i-B;
            if(i-B>max_increasing && i-B>0)
                max_increasing = i-B;

        }
        int min_decreasing = Integer.MAX_VALUE;
        int max_decreasing = Integer.MIN_VALUE;
        for(int i:A) {
            if (i + B < min_decreasing)
                min_decreasing = i+B;
            if(i+B>max_decreasing)
                max_decreasing = i+B;

        }
        System.out.println(min_increasing +" , "+max_increasing);

        System.out.println(min_decreasing +" , "+max_decreasing);

        return Integer.min(max_decreasing,max_increasing) - Integer.max(min_decreasing,min_increasing);
    }
    public static void main(String args[]){
        int A[] = {1,2,3,4,5};
        MaximumMinimumDifference ob = new MaximumMinimumDifference();
        System.out.println(ob.solve(A,2));
    }
}
