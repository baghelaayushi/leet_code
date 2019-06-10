public class FindDuplicate {
    //function to find the duplicates in a given array
    static int find(int[] arr){
        if(arr.length>0){
            int range = arr.length + 1;

            // A count array
            // Range from length zero to the maximum value in array
            int[] count = new int[range + 1];

            // Changing value in count array
            // Index at count refers to value in the array
            for (int i = 0; i < arr.length; i++)
            {
                count[arr[i]]++;
            }

            //Checking for index with count two
            for(int i = 0;i< count.length;i++)
                if(count[i] >= 2)
                    return i;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums = {1, 3, 4, 2, 2};
        int output = find(nums);
        System.out.println(output);


    }
}
