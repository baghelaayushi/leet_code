import java.util.ArrayList;
import java.util.List;

public class LargestBSTSubtree {
    static int max_count =0;
    static TreeNode current = null;
    public static List<Integer> solveUtil(TreeNode A) {
        if (A == null) {
            List<Integer> temp = new ArrayList<>();
            temp.add(0);
            temp.add(Integer.MIN_VALUE);
            temp.add(Integer.MAX_VALUE);
            return temp;
        }
        List<Integer> lst = solveUtil(A.left);
        List<Integer> rst = solveUtil(A.right);

        if (lst.get(0) != -1 && rst.get(0) != -1 && A.val > lst.get(1) && A.val < rst.get(2)) {
            int sum = lst.get(0) + rst.get(0) + 1;
            if (sum > max_count) {
                max_count = sum;
                current = A;
            }
            List<Integer> temp = new ArrayList<>();
            temp.add(sum);
            temp.add(Integer.max(rst.get(1),A.val));
            temp.add(Integer.min(lst.get(2),A.val));
            return temp;
        } else {
            List<Integer> temp = new ArrayList<>();
            temp.add(-1);
            temp.add(Integer.max(rst.get(1),A.val));
            temp.add(Integer.min(lst.get(2),A.val));
            return temp;

        }
    }
    public static int solve(TreeNode A) {
        solveUtil(A);
        return max_count;
    }
    public static void main(String args[]){
        System.out.println(solve(CreateTree.createTree()));
    }
}
