public class Build {
    static void printHeap(int arr[])
    {
        System.out.println("Array representation of Heap is:");

        for (int i = 0; i <arr.length; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
    public static void main(String args[]){
        int arr[] = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        CreateHeap.buildHeapMin(arr,arr.length);
        printHeap(arr);
        CreateHeap.buildHeapMax(arr,arr.length);
        printHeap(arr);

        int A[] = AddValue.AddValueMax(arr,18);
        printHeap(A);

        DeleteRoot.deleteMax(A);
        printHeap(A);
    }
}
