public class RotatedArray {

    public static boolean check(int[] nums) {
        if(nums.length == 1 || nums.length == 2)
            return true;

        int indexArr = 0;
        while(indexArr < nums.length-1 && nums[indexArr] <= nums[indexArr +1]){
            indexArr++;
        }

        indexArr ++;
        if(indexArr == nums.length)
            return true;
        while(indexArr < nums.length-1 && nums[indexArr] <= nums[indexArr +1]){
            indexArr++;
        }
        return indexArr == nums.length-1 && nums[0] >= nums[indexArr];
    }

    public static void main(String args[]){
        int[] nums = new int[]{3,6,10,1,8,9,9,8,9};
        System.out.println(check(nums));
    }
}
