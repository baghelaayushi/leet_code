import java.util.*;
import java.util.stream.Collectors;

public class combinationSumTwo {
    static List<List<Integer>> output = new ArrayList();
    static void solveCSUtil(int arr[], int sum, int pos, int target, List<Integer> numberSum){
        if(sum >target)
            return;
        if(sum == target){
            output.add(numberSum);
            return;
        }
        for (int i = pos; i < arr.length; i++) {
            ArrayList<Integer> copy = new ArrayList<>(numberSum);
            copy.add(arr[i]);
            solveCSUtil(arr,sum+arr[i],i+1,target,copy);
        }

    }

    public static void main(String[] args){
        Queue queue1 = new LinkedList();
        int nums[] = {10,1,2,7,6,1,5};
        Arrays.sort(nums);
        int target = 8;
        output.clear();
        solveCSUtil(nums,0,0,target,new ArrayList<>());
        System.out.println(output.stream().distinct().collect(Collectors.toList()));

    }
}
