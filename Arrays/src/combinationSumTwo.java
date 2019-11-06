import java.util.*;
import java.util.stream.Collectors;

public class combinationSumTwo {
    static ArrayList<ArrayList<Integer>> output = new ArrayList();
    static ArrayList<Integer> arr = new ArrayList<>();
    static int target;

    static void solveCSUtil(int index,int sum,ArrayList<Integer> numberSum){
        sum += arr.get(index);
        if(sum >target)
            return;
        numberSum.add(arr.get(index));
        if(sum == target){
            output.add(numberSum);
            return;
        }
        System.out.println(index);
        ArrayList<Integer> copy = new ArrayList<>(numberSum);
        if(index+1<arr.size())
            solveCSUtil(index+1,sum,copy);

        for (int i = index+2; i < arr.size(); i++) {
            copy = new ArrayList<>(numberSum);
            if(arr.get(i-1)!=arr.get(i))
                solveCSUtil(i,sum,copy);
        }

    }
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        output.clear();
        arr.clear();
        arr = a;
        target =b;
        solveCSUtil(0,0,new ArrayList<>());
        for(int i=1;i<arr.size();i++)
            if(arr.get(i-1)!=arr.get(i))
                solveCSUtil(i,0,new ArrayList<>());

        return output;
    }

    public static void main(String[] args){
        Queue queue1 = new LinkedList();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(5);
        a.add(8);
        a.add(8);
        a.add(10);
        a.add(11);

        System.out.println(combinationSum(a,28));

    }
}
