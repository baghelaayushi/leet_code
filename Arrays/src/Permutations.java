import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    static List<List<Integer>> lst = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();
    static void permuteUtil(int a[], int size, int n){
        if (size == 1)
        {
            //temp = new ArrayList<>();
            for(int i:a)
                temp.add(i);
            lst.add(temp);
            return;
        }

        for (int i=0; i<size; i++)
        {
            permuteUtil(a,size-1,n);

            // if size is odd, swap first and last
            // element
            if (size%2==1) {
                int temp_int = a[0];
                a[0] = a[size-1];
                a[size-1] = temp_int;
            }

                // If size is even, swap ith and last
                // element
            else {
                int temp_int = a[i];
                a[i] = a[size-1];
                a[size-1] = temp_int;
            }
        }

    }
    static int[][] permute(int[] A){
        lst = new ArrayList<>();
       temp = new ArrayList<>();
       int n = A.length-1;
       permuteUtil(A,n,n);
        int output[][] = new int[lst.size()][];
        int j =0;
        System.out.println(lst);
        for(List<Integer> a: lst) {
            int arr[] = new int[a.size()];
            for (int i : a) {
                int k = 0;
                arr[k] = i;
                k++;
            }
            output[j] = arr;
            j++;
        }
        return output;

    }
    public static void main(String args[]){
        int arr[] = {1,2,3};
        permute(arr);
    }
}
