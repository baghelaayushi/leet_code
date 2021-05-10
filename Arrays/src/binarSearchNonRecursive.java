public class binarSearchNonRecursive {
    public static int bSearch(int[] arr, int digit, int l, int r) {
        while (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the middle
            // itself
            if (arr[mid] == digit)
                return mid;

            // If element is greater than mid move r to mid -1
            // If element is smaller than mid move l to mid + 1
            if (arr[mid] > digit) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        System.out.println(bSearch(arr,9, 0, arr.length -1));
    }
}
