public class canPartitionKSubsets {
    static int sum=0;
    public int isValid(int arr[]){
        int count =0;
        for(int i:arr) {
            if (i > sum)
                return 1;
            if (i == sum)
                count++;
        }
        if(count == arr.length)
            return 0;

        return 2;
    }
    public boolean canPartitionKSubsetsUtil(int arr[], int nums[], int index, int changed_value){
        if(index>nums.length)
            return false;
        if(changed_value> sum || isValid(arr) == 1)
        return false;

        if(index == nums.length && isValid(arr) == 0)
            return true;

        for(int i=0;i<arr.length;i++){
            arr[i] += nums[index];
            if(canPartitionKSubsetsUtil(arr,nums,index+1,arr[i]))
                return true;
            arr[i] -= nums[index];
        }

        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sums =0;
        for(int i:nums)
            sums+= i;

        if(sums%k!=0)
            return false;

        int arr[] = new int[k];
        sum = sums/k;
        return canPartitionKSubsetsUtil(arr,nums,0, arr[0]);
    }
    public static void main(String args[]){
        canPartitionKSubsets ob  = new canPartitionKSubsets();
        int arr[] = {960,3787,1951,5450,4813,752,1397,801,1990,1095,3643,8133,893,5306,8341,5246};
        System.out.println(ob.canPartitionKSubsets(arr,6));
    }
}
