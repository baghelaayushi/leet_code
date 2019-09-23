import java.util.HashSet;
import java.util.Set;

public class EqualTreePartition {
    static HashSet<Integer> hs = new HashSet<>();
    static int find_sum(TreeNode A) {
        if(A==null)
            return 0;
        if(A.left == null && A.right == null)
            return A.val;

        int lst = find_sum(A.left);
        int rst = find_sum(A.right);
        //System.out.println(lst);
        //System.out.println(rst);
        hs.add(lst);
        hs.add(rst);
        return A.val + find_sum(A.left)+find_sum(A.right);
    }

    public static int solve(TreeNode A) {

        if(hs.contains((find_sum(A))/2))
            return 1;

        return 0;
    }

    public static void main(String args[]){

        System.out.println(solve(BinaryTree.createTree()));
        //for(int i: hs)
        //    System.out.println(i);
    }
}
