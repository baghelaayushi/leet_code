import java.util.*;
import java.util.stream.Collectors;

public class combinationSumTwo {
    static List<List<Integer>> output = new ArrayList();
    static void solveCSUtil(ArrayList<Integer> arr, int sum, int pos, int target, List<Integer> numberSum){
        if(sum >target)
            return;
        if(sum == target){
            output.add(numberSum);
            return;
        }
        for (int i = pos; i < arr.size(); i++) {
            ArrayList<Integer> copy = new ArrayList<>(numberSum);
            copy.add(arr.get(i));
            solveCSUtil(arr,sum+arr.get(i),i+1,target,copy);
        }

    }

    public static void main(String[] args){
        Queue queue1 = new LinkedList();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(10);
        a.add(1);
        a.add(2);
        a.add(7);
        a.add(6);
        a.add(1);
        a.add(5);

        Collections.sort(a);
        int target = 8;
        output.clear();
        solveCSUtil(a,0,0,target,new ArrayList<>());
        System.out.println(output);

    }
}
