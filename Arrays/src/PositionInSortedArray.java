import java.util.ArrayList;
import java.util.List;

class PositionInSortedArray{
    static int bSearchMin(int arr[],int l,int r,int digit){
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the middle
            // and the element before is smaller
            // or the position is the starting position
            if (arr[mid] == digit &&(mid-1 == -1 || arr[mid -1] < digit))
                return mid;

            // If element is less than or equals to mid, then
            // it can only be present in left subarray,
            // the start of the element is left to the mid position
            if (arr[mid] >= digit)
                return bSearchMin(arr, l, mid - 1,digit);

            // Else the element can only be present
            // in right subarray
            return bSearchMin(arr, mid + 1, r,digit);
        }

        // We reach here when element is not
        // present in array
        return -1;
    }

    static int bSearchMax(int arr[],int l,int r,int digit){
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the middle
            // and the element after is greater
            // or the position is the end position
            if (arr[mid] == digit &&(mid+1 == arr.length || arr[mid +1] > digit))
                return mid;

            // If element is greater than or equals to mid, then
            // it can only be present in right subarray
            if (arr[mid] <= digit)
                return bSearchMax(arr, mid + 1, r,digit);

            // Else the element can only be present
            // in right subarray
            return bSearchMax(arr, l, mid - 1,digit);

        }

        // We reach here when element is not
        // present in array
        return -1;
    }

    public static void main(String args[]) {
        int nums[] = {1,2,2,3,8,9,10};
        int target =  4;
        int min= bSearchMin(nums,0,nums.length-1,target);
        int max = bSearchMax(nums,0,nums.length-1,target);
        List<Integer> nums1 = new ArrayList<>();

        int arr[] = {min,max};
        System.out.print(arr[0]+","+arr[1]);

    }
}
