public class FirstMissing {
    public int firstMissingPositive(int[] nums) {
        int m = Integer.MIN_VALUE;
        int i =0;
        while(i<nums.length){
            if(nums[i]<=0 || nums[i]>=nums.length || nums[i]== Integer.MIN_VALUE)
                i++;
            else if(nums[i]>i){
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = m;
            }
            else if(nums[i]<i){
                int temp = nums[i];
                nums[temp-1] = m;
                i++;
            }
            else if(nums[i]-1 == i)
                nums[i] = m;
        }
        int output= 1;
        for(int j=0;j<nums.length;j++){
            if(nums[j] != m) {
                output = j + 1;
                //break;
            }
            System.out.println(nums[j]);
        }

        return output;

    }
    public static void main(String args[]){
       FirstMissing ob = new FirstMissing();
       int nums[] = {3,4,-1,1};
       System.out.println(ob.firstMissingPositive(nums));
    }
}

