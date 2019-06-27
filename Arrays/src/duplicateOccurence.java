import java.util.ArrayList;
import java.util.List;

public class duplicateOccurence {
    static int[] findNOccurence(int A[]){
        int arr[] = {-1,-1};
        if(A.length>0){
            int range = A.length + 1;

            // A count array
            // Range from length zero to the maximum value in array
            int[] count = new int[range];

            // Changing value in count array
            // Index at count refers to value in the array
            for (int i = 0; i < A.length; i++)
            {
                count[A[i]]++;
            }

            //Checking for index with count two
            for(int i = 1;i< count.length;i++) {
                if (count[i] == 2)
                    arr[0] = i;
                if (count[i] == 0)
                    arr[1] =i;
            }
            return arr;
        }
        return arr;
    }
    public static void main(String args[]){
        int A[] = {3,1,2,5,3};
        int arr[] = findNOccurence(A);
        System.out.println(arr[0] +","+ arr[1]);
    }
}
