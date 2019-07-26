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
            if (L[i][0] <= R[j][0]) {
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
public class BusAndPassengers {
    static int[] solve(int[] A, String B){
        int temp[][] = new int[A.length][2];
        int temp2[][] = new int[A.length][2];
        int temp1[][] = new int[A.length][2];
        int n = A.length;
        int max_index = 0;
        for(int i= 0;i <n; i++){
            temp[i][0] = A[i];
            temp[i][1] = i;
        }

        MergeSortTwoD ob = new MergeSortTwoD();
        ob.sort(temp,0,n-1);

        int j=n-1;

        for(int i= 0;i <n; i++){
            temp2[j][0] = temp[i][0];
            temp2[j][1] = temp[i][1];
            j--;
        }

        int output[] = new int[B.length()];
        int i=0;
        j=temp2.length-1;
        for(int k=0;k<B.length();k++){
            if(B.charAt(k) == '0'){
                temp1[i][0] = temp2[j][0];
                temp1[i][1] = temp2[j][1];
                output[k] = temp1[i][1]+1;
                i++;
                j--;
            }
            else{
                output[k] = temp1[i-1][1]+1;
                i--;
            }
        }
        return output;
    }
    public static void main(String args[]){
        int arr[] = {10,8,9,11,13,5};
        int x[] = solve(arr,"010010011101");
        for(int i=0;i<x.length;i++)
            System.out.println(x[i]);

    }
}
