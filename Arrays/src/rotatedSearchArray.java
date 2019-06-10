public class rotatedSearchArray {
    public static int find(int[] arr, int digit, int l, int r){
        if (r >= l) {
            int mid = l + (r - l) / 2;
            System.out.println(mid);

            // If the element is present at the middle
            // itself
            if (arr[mid] == digit)
                return mid;
            if(arr[l] == digit)
                return l;
            if(arr[r] == digit)
                return r;
            //If element is smaller than the right most value
            if(digit>arr[l]){
                if(arr[mid]>arr[l]){
                    if(digit < arr[mid])
                        return find(arr, digit ,l,mid-1);
                    if(digit > arr[mid])
                        return find(arr, digit ,mid+1,r);}
                if(arr[mid]<arr[l]){
                    return find(arr, digit ,l,mid-1);
                }
            }
            if(digit < arr[r]){
                if(arr[mid]>arr[l])
                    return find(arr, digit ,mid+1,r);
                if(arr[mid]<arr[l]){
                    if(digit < arr[mid])
                        return find(arr, digit ,l,mid-1);
                    if(digit > arr[mid])
                        return find(arr, digit ,mid+1,r);
                }
            }

        }

        // We reach here when element is not
        // present in array
        return -1;
    }
    public static void main(String[] args){
        int[] nums = {8, 9, 2, 3, 4};
        int digit = 9;
        int l=0,r=nums.length -1;
        int x = find(nums,digit,l,r);
        System.out.println(x);


    }
}
