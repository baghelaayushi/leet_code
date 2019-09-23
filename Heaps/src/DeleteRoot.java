import java.util.Arrays;

public class DeleteRoot {
    static void delete(int[] A){
        A[0] = A[A.length-1];
        A = Arrays.copyOfRange(A,0,A.length-1);
    }
    static void deleteMax(int[] A){
        delete(A);
        CreateHeap.buildHeapMax(A,A.length);
    }
    static void deleteMin(int[] A){
        delete(A);
        CreateHeap.buildHeapMin(A,A.length);
    }
}
