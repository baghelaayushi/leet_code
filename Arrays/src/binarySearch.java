public class binarySearch {
    public static int bSearch(int[] arr, int digit, int l, int r){
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the middle
            // itself
            if (arr[mid] == digit)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > digit)
                return bSearch(arr, digit ,l, mid - 1);

            // Else the element can only be present
            // in right subarray
            return bSearch(arr, digit ,mid + 1, r);
        }

        // We reach here when element is not
        // present in array
        return -1;
    }
}
