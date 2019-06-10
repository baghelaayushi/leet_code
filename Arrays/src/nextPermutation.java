import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nextPermutation {

    public static void main(String[] args){
        int[] nums = {5, 1, 1};
     int greatest = nums.length - 1;
     int nextNumber;
     while(greatest>0){
         if(nums[greatest-1]>=nums[greatest])
             greatest--;
         else
             break;

     }
     nextNumber = greatest;
     int temp = greatest,i;
     if(greatest==0)
         Arrays.sort(nums);
     else{
         while(nextNumber<=nums.length-1){
             if(nums[nextNumber]>nums[greatest-1] && nums[nextNumber]<nums[temp]){
                 temp = nextNumber;
             }
             nextNumber++;
         }
         int temp1 = nums[greatest-1];
         nums[greatest-1] = nums[temp];
         nums[temp] = temp1;
         Arrays.sort(nums,greatest,nums.length);
     }
     List<Integer> output = new ArrayList<>();
     for(i = 0; i <= nums.length-1;i++)
         output.add(nums[i]);
     System.out.println(output);
    }

}
