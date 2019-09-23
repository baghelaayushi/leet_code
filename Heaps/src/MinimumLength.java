import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumLength {
    static int sum =0;
    static void heapify_max(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify_max(arr, n, largest);
        }
    }
    static void buildHeapMax(int arr[], int n)
    {
        // Index of last non-leaf node
        int startIdx = (n / 2) - 1;

        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int i = startIdx; i >= 0; i--) {
            Heapify.heapify_max(arr, n, i);
        }
    }
    static int[] AddToArray(int A[],int val){
        int temp[] = new int[A.length+1];
        int i;
        for(i=0;i<A.length;i++)
            temp[i] = A[i];

        temp[i] = val;

        return temp;
    }
    static int[] AddValueMax(int A[],int val){
        int temp[] = AddToArray(A,val);
        CreateHeap.buildHeapMax(temp,temp.length);
        return temp;
    }
    static void delete(int[] A){
        A[0] = A[A.length-1];
        A = Arrays.copyOfRange(A,0,A.length-1);
    }
    static void deleteMax(int[] A){
        delete(A);
        CreateHeap.buildHeapMax(A,A.length);

    }
    public static int solveUtil(int[] A) {
        if(A.length == 2)
            return sum+ A[0] + A[1];

        buildHeapMax(A, A.length);
        int s1 = A[0];
        deleteMax(A);
        int s2 = A[0];
        deleteMax(A);
        sum += s1 + s2;
        AddValueMax(A, s1 + s2);
        solveUtil(A);
        return sum;
    }
    public static int solve(int[] A){
        sum =0;
        return solveUtil(A);
    }
    public static void main(String[] args){
        int a[] = {1,2,3,4,5};
        System.out.println(solve(a));

    }
}
