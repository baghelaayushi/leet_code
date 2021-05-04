public class ZigZagArray {
    public static int movesToMakeZigzag(int[] nums) {
        int numsSize = nums.length;
        if(numsSize == 1)
            return 0;
        if(numsSize == 2) {
            if(nums[0] == nums[1])
                return 1;
            return 0;
        }

        int maxMoves = Integer.MIN_VALUE;
        int count = 0;
        int index = 0;
        if(nums[index] >= nums[index + 1])
            count += (nums[index] - nums[index+1] + 1);

        index +=2;

        while(index < numsSize-1){
            if(nums[index ] >= nums[index-1] || nums[index] >= nums[index+1])
                count += (nums[index] - Integer.min(nums[index-1], nums[index+1]) + 1);

            index += 2;
        }

        if(index==numsSize-1 && nums[index] >= nums[index-1])
            count += (nums[index] - nums[index-1] + 1);


        maxMoves = Integer.max(count, maxMoves);
        count = 0;
        index = 1;

        while(index < numsSize-1){
            if(nums[index ] >= nums[index-1] || nums[index] >= nums[index+1])
                count += (nums[index] - Integer.min(nums[index-1], nums[index+1]) + 1);

            index += 2;
        }

        if(index == numsSize)
            return Integer.min(count, maxMoves);

        if(nums[index] >= nums[index-1])
            count += nums[index] - nums[index-1] + 1;

        return Integer.min(count, maxMoves);
    }

    public static void main(String args[]){
        int[] nums = new int[]{1,2,3,1};
        System.out.println(movesToMakeZigzag(nums));
    }
}
