public class LongestIncreasingDecreasingSubsequence {
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

        int arr1[] = new int[A.length];
        arr1[A.length-1] = 1;
        for(int i =A.length-2;i>=0;i--) {
            int min = 0;
            for (int j =A.length-1;j>i;j--){
                if(A[j]<A[i]&& arr1[j]>min)
                    min = arr1[j];
            }
            arr1[i] = min+1;
        }

        int max =0;
        for(int i=0;i<arr.length;i++)
            if(arr[i]+arr1[i]>max)
                max =arr[i]+arr1[i];

        return max-1;
    }
    public static void main(String[]  args){
        int A[] = {1, 2, 1};
        System.out.println(lis(A));
    }
}
