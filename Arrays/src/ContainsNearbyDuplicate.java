import java.util.HashMap;
import java.util.Set;

public class ContainsNearbyDuplicate {
    public static void printMap(HashMap<Integer, Integer> printableMap){
        Set<Integer> keys = printableMap.keySet();
        for(Integer i: keys){
            System.out.print(i + "->");
            System.out.print(printableMap.get(i));
            System.out.println();
        }
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> nearByMap = new HashMap<>();
        for (int index = 0; index < nums.length; index++ ){
            if(nearByMap.containsKey(nums[index]) && (index - nearByMap.get(nums[index])) <=k){
                return true;
            }

            nearByMap.put(nums[index], index);
        }

        return false;

    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums, 2));
    }
}
