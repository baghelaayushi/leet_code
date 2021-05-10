import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for(int i: nums){
            uniqueNums.add(i);
        }

        return uniqueNums.size() < nums.length;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        System.out.println(containsDuplicate(nums));
    }
}
