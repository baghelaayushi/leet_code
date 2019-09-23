import java.util.Arrays;

public class AddValue {
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
    static int[] AddValueMin(int A[],int val){
        int temp[] = AddToArray(A,val);
        CreateHeap.buildHeapMin(temp,temp.length);
        return temp;
    }
}
