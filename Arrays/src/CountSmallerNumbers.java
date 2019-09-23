import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmallerNumbers {
    public static int bSearchlist(List<Integer> lst, int digit, int l, int r){
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the middle
            // itself
            if (lst.get(mid) == digit)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (lst.get(mid) > digit)
                return bSearchlist(lst, digit ,l, mid - 1);

            // Else the element can only be present
            // in right subarray
            return bSearchlist(lst, digit ,mid + 1, r);
        }

        // We reach here when element is not
        // present in array
        return -1;
    }
    public static int[] solve(int[] A) {
        int output[] = new int[A.length];
        int temp[] = new int[A.length];
        for (int i=0;i<A.length;i++)
            temp[i] = A[i];
        List<Integer> lst = new ArrayList<>();
        //MergeSort ob = new MergeSort();
        //ob.sort(temp,0,temp.length);
        Arrays.sort(temp);
        for (int i=0; i<A.length;i++){
            lst.add(temp[i]);
        }
        System.out.println(lst);
        for(int i = 0;i<A.length;i++){
            int x = bSearchlist(lst,A[i],0,lst.size()-1);
            while (x>0 && lst.get(x).equals(lst.get(x-1)))
                x--;
            output[i] = x;
            lst.remove(output[i]);
        }
        return output;
    }
    public static void main(String args[]){
        int A[] = {140, 476, 477, 386, 413, 200, 407, 181, 248, 276, 77, 248, 222, 144, 292, 197};
        int x[] = solve(A);
        for (int i=0;i<x.length;i++)
            System.out.print(x[i]+" ");
    }
}
