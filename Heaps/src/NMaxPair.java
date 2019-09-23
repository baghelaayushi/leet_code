import java.util.Arrays;
import java.util.Collections;

public class NMaxPair {
    static int arr[];
    static void heapify_min(int arr[], int n, int i)
    {
        int smallest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] < arr[smallest])
            smallest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] < arr[smallest])
            smallest = r;

        // If largest is not root
        if (smallest != i) {
            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;

            // Recursively heapify the affected sub-tree
            heapify_min(arr, n, smallest);
        }
    }
    static void buildHeapMin(int arr[], int n)
    {
        // Index of last non-leaf node
        int startIdx = (n / 2) - 1;

        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int i = startIdx; i >= 0; i--) {
            heapify_min(arr, n, i);
        }
    }

    public static void makeHeap(int sum){
        if(sum >= arr[0]){
            arr[0] = sum;
            heapify_min(arr,arr.length,0);
        }
    }
    public static int[] solve(int[] A, int[] B) {
        arr = new int[A.length];
        for(int i=0;i<B.length;i++){
            arr[i] = A[0] + B[i];
        }
        buildHeapMin(arr,arr.length);
        for(int i=1;i<A.length;i++)
            for(int j=0;j<B.length;j++)
                makeHeap(A[i]+B[j]);

        int temp;
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[i] < arr[j])
                {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }


        return arr;
    }
    public static void main(String args[]){
        int A[] = {3, 2, 4, 2};
        int B[] = {4, 3, 1, 2};
        Build.printHeap(solve(A,B));
    }
}
