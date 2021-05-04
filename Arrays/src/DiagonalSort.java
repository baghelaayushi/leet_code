public class DiagonalSort {
    void mergeDiagonal(int arr[][], int li,int lj, int mi,int mj, int ri,int rj) {
        // Find sizes of two subarrays to be merged
        int n1 = mi - li + 1;
        int n2 = ri - mi;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        int m = li;
        int n = lj;
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[m][n];
            m++;
            n++;
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m][n];
            m++;
            n++;
        }


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        m = li;
        n = lj;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[m][n] = L[i];
                i++;
            } else {
                arr[m][n] = R[j];
                j++;
            }
            m++;
            n++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[m][n] = L[i];
            i++;
            m++;
            n++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[m][n] = R[j];
            j++;
            m++;
            n++;
        }
    }
    void sort(int arr[][], int li, int ri, int lj, int rj) {
        if (li < ri && lj < rj) {
            // Find the middle point
            int mi = (li + ri) / 2;
            int mj = (lj + rj) / 2;

            // Sort first and second halves
            sort(arr, li,mi,lj,mj);
            sort(arr, mi + 1,ri, mj+1, rj);

            // Merge the sorted halves
            mergeDiagonal(arr, li,lj, mi,mj, ri,rj);
        }
    }
    public int[][] diagonalSort(int[][] mat) {
        int li = mat.length-1;
        int lj = 0;
        int ri = mat.length-1;
        int rj = 0;

        while (li>=0){
            sort(mat,li,ri,lj,rj);
            li--;
            rj++;
        }
        li =0;
        lj++;
        while(rj<mat[0].length){
            sort(mat,li,ri,lj,rj);
            rj++;
            lj++;
        }


        return mat;

    }

    public static void main(String[] args) {
        int[][] arr = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};

    }
}
