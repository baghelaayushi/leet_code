import java.util.ArrayList;
import java.util.List;

public class twoSum {
    public static int linearSearch(int[] arr, int digit, int l, int r){
        while(l<=r){
            if(arr[l] == digit){
                return l;
            }
            l++;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums = {4, 5, 11, 15};
        int[] output = new int[2];
        int target = 26;
        int temp;
        for(int i = 0;i<=nums.length -1;i++){
            temp = target - nums[i];
            int x = linearSearch(nums,temp,i+1,nums.length-1);
            if( x!= -1){
                output[0]= nums[i];
                output[1]=nums[x];
            }
        }
        System.out.println(output[0]+","+output[1]);

    }
}
