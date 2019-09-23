import java.util.ArrayList;
import java.util.List;

public class PathSum {
    static  int sum =0;
    public static int hasPathSumUtil(TreeNode A, int B) {
        if(A== null)
            return 0;
        if(B + A.val== sum && A.left == null && A.right == null )
            return 1;

        if(hasPathSumUtil(A.left,B+A.val) == 1)
            return 1;

        if(hasPathSumUtil(A.right,B+A.val) == 1)
            return 1;

        return -1;

    }

    public static int hasPathSum(TreeNode A, int B) {
     sum =B;
     if(hasPathSumUtil(A,0) == 1)
         return 1;

     return 0;

    }
    public static void main(String args[]){
         System.out.println(hasPathSum(BinaryTree.createTree(),20));
    }
}
