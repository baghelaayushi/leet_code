public class MaxSumElements {
    static int previous = 0;
    static int next =0;
    public static int adjacent(int[][] A) {
        int arr[] = new int[A[0].length];
        for(int i =0;i<A[0].length;i++)
            arr[i] = Integer.max(A[0][i],A[1][i]);
        if(arr.length ==1)
            return arr[0];
        if(arr.length==2)
            return Integer.max(arr[0],arr[1]);
        previous =arr[0];
        next = Integer.max(arr[0],arr[1]);
        for(int j=2;j<arr.length;j++){
            int temp = next;
            next = Integer.max(next,previous+arr[j]);
            previous = temp;
        }
        return next;
    }

    public static void main(String args[]){
        int[][] A = {{1,2,3,4},{2,3,4,5}};
        System.out.println(adjacent(A));

    }
}
