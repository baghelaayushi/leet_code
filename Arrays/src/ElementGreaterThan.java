public class ElementGreaterThan {
    static int bSearchMaxUtil(int arr[],int l,int r,int digit){
        if (r >= l) {
            int mid = l + (r - l) / 2;


            // If the element is present at the middle
            // and the element after is greater
            // or the position is the end position
            if (arr[mid] == digit &&(mid+1 == arr.length || arr[mid +1] > digit))
                return mid;

            if(arr[mid] > digit && arr[mid-1]<digit)
                return mid-1;

            // If element is greater than or equals to mid, then
            // it can only be present in right subarray
            if (arr[mid] <= digit)
                return bSearchMaxUtil(arr, mid + 1, r,digit);

            // Else the element can only be present
            // in right subarray
            return bSearchMaxUtil(arr, l, mid - 1,digit);

        }

        // We reach here when element is not
        // present in array
        return -1;
    }
    static int bSearchMax(int arr[],int l,int r,int digit){
        if(digit<arr[0])
            return 0;
        if(digit>arr[r])
            return -1;

        return bSearchMaxUtil(arr,l,r,digit)+1;
    }
    public static void main(String args[]){
        int A[] = {-14,-10,2,108,108,243,243,243,243,243,243,401};
        int x = bSearchMax(A,0,A.length-1,285);
        System.out.println(x);
        int low =0;
        int k = 243;
        int high =  A.length - 1;

        while (low <= high){
            int mid = low+(high-low)/2;

            if (A[mid] <= k) {
                low = mid + 1;
            }else if(A[mid] > k){
                high = mid -1;
            }
        }

        int y = low < A.length-1 ? A[low] : -1;
        System.out.println(y);
    }
}
