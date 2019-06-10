import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class combinationSum {
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
                    solveCSUtil(arr,sum+arr[i],i,target,copy);
                }

    }

    public static void main(String[] args){
        Queue queue1 = new LinkedList();
        int nums[] = {2,3,5};
        int target = 8;
        solveCSUtil(nums,0,0,target,new ArrayList<>());
        System.out.println(output);

    }
}

