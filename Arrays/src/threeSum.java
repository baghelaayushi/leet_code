import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class threeSum {

    public static void main(String[] args){
        int[] nums = {0, 0, 0};
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int len=nums.length,len1 = nums.length;
        int num1=0,num2,num3=len-1;
        while(len1 > 2 && nums[num1]<=0){
            while(num3 > num1+1 && nums[num3]>=0){
                //System.out.println(num1+","+num3);
                int twoSum = nums[num1]+nums[num3];
                //System.out.println(-(twoSum));
                num2 = binarySearch.bSearch(nums,-twoSum,num1+1,num3-1);
                /*while(nums[num2] != -(twoSum) && num2>num1){
                    num2--;
                }*/
                if (num2 != -1){
                    //System.out.println(nums[num1]+","+nums[num2]+","+nums[num3]);
                    List<Integer> numbers = new ArrayList<>();
                    numbers.add(nums[num1]);
                    numbers.add(nums[num2]);
                    numbers.add(nums[num3]);
                    if(nums[num1] == -1119)
                        System.out.println(numbers);
                    //System.out.println(numbers);
                    result.add(numbers);
                }
                if(nums[num3]==0)
                    break;
                num3--;
            }
            num3=len-1;
            num1++;
            len1--;
        }
        System.out.println(result.stream().distinct().collect(Collectors.toList()));

    }
}
