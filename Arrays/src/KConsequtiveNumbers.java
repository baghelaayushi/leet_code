import java.util.Map;
import java.util.TreeMap;

public class KConsequtiveNumbers {

    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length%k !=0)
            return false;
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        int min = Integer.MAX_VALUE;
        for(int i: nums){
            if(!tm.containsKey(i)){
                tm.put(i,1);
            }
            else {
                int x = tm.get(i);
                tm.replace(i,x+1);
            }
            min = Math.min(min,i);
        }
        for (int key : tm.keySet()) {
            if (tm.get(key) == 0) continue;
            for (int i = 1; i < k; i++) {
                tm.put(key + i, tm.getOrDefault(key + i, 0) - tm.get(key));
                if (tm.get(key + i) < 0) return false;
            }
        }
        return true;


    }
}
