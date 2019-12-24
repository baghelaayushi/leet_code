public class SumTree {
    public int solveUtil(TreeNode A){
        if(A.left == null && A.right== null)
            return A.val;
        else if(A.left==null){
            int sum = solveUtil(A.right);
            if(sum == -1 || sum != A.val)
                return -1;
            else
                return sum+A.val;
        }
        else if(A.right==null){
            int sum = solveUtil(A.left);
            if(sum == -1 || sum != A.val)
                return -1;
            else
                return sum+A.val;
        }
        int left_sum = solveUtil(A.left);
        int right_sum = solveUtil(A.right);
        if(left_sum == -1 || right_sum == -1)
            return -1;

        if(A.val == left_sum + right_sum)
            return A.val + left_sum + right_sum;
        else
            return -1;
    }
    public int solve(TreeNode A) {
        int output = solveUtil(A);
        //System.out.println(output);
        if(output == -1)
            return 0;
        else
            return 1;
    }
}
