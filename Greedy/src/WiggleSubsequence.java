public class WiggleSubsequence {
    public static void main(String []args){
        int nums[] ={3,3,3,2,4,3};
        int arr[] = new int[nums.length];
        if(nums.length == 0)
            System.out.print(0);
        if (nums.length == 1)
            System.out.print(1);
        // a true toggle represents that difference of previous integers was positive
        // and a false toggle represents a negative difference
        // count in the maximum length of sub array;
        boolean toggle;
        int count =1;
        int length = nums.length;

        // setting initial toggle
        if(nums[1]- nums[0]>= 0){
            toggle = false;
        }
        else{
            toggle = true;
        }
        for(int i=0;i<nums.length-1;i++) {
            if(nums[i+1]- nums[i]==0) {
                // iterate over the equal consecutive value
                while (i < nums.length - 1 && nums[i + 1] == nums[i])
                    i++;
                i--;
            }
            if(i < nums.length-1) {
                if (nums[i + 1] > nums[i]) {
                    if (!toggle) {
                        toggle = true;
                        count++;
                        System.out.print(nums[i]+",");
                    }
                } else {
                    if (toggle) {
                        toggle = false;
                        count++;
                        System.out.print(nums[i]+",");
                    }
                }
            }
        }
     System.out.println(count);
    }

    
}
