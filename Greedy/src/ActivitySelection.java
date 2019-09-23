class MergeSortTwoD {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[][], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[][] = new int[n1][2];
        int R[][] = new int[n2][2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            L[i][0] = arr[l + i][0];
            L[i][1] = arr[l + i][1];
        }
        for (int j = 0; j < n2; ++j) {
            R[j][0] = arr[m + 1 + j][0];
            R[j][1] = arr[m + 1 + j][1];
        }

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i][1] <= R[j][1]) {
                arr[k][0] = L[i][0];
                arr[k][1] =L[i][1];
                i++;
            } else {
                arr[k][0] = R[j][0];
                arr[k][1] = R[j][1];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k][0] = L[i][0];
            arr[k][1] =L[i][1];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k][0] = R[j][0];
            arr[k][1] = R[j][1];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[][], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}
public class ActivitySelection {

    public static int solveUtil(int A[][]){
        int count =1;
        MergeSortTwoD ob = new MergeSortTwoD();
        ob.sort(A,0,A.length-1);

        int j=0;

        for(int i =1;i<A.length;i++){
            if(A[j][1]<=A[i][0]){
                count++;
                j++;
            }
            else {
                A[j+1][1] = A[j][1];
                j++;
            }
        }
        return count;

    }
    public static int solve(int[] A, int[] B) {
        int arr[][] = new int[A.length][2];
        for(int i = 0;i<A.length;i++){
            arr[i][0] = A[i];
            arr[i][1] = B[i];
        }
        return solveUtil(arr);
    }
    public static void main(String args[]){
        int A[] = {17, 8, 14, 24, 10, 8, 1, 30};
        int B[] = {18, 45, 24, 27, 18, 10, 38, 35};
        System.out.println(solve(A,B));
     }
}
