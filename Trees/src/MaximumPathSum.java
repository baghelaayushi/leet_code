public class MaximumPathSum {
    static int max = Integer.MIN_VALUE;
    public int maxPathSumUtil(TreeNode root){
        if(root == null)
            return 0;

        int left_val = maxPathSumUtil(root.left);
        int right_val = maxPathSumUtil(root.right);

        if(max<left_val +root.val+right_val)
            max = left_val +root.val+right_val;

        if(max < left_val +root.val)
            max =  left_val +root.val;

        if(max < right_val +root.val)
            max =  right_val +root.val;

        if(max<root.val)
            max = root.val;

        return Integer.max(left_val +root.val,Integer.max(right_val +root.val,root.val));
    }
    public int maxPathSum(TreeNode root) {
        max =Integer.MIN_VALUE;
        maxPathSumUtil(root);
        return max;
    }
    public static void main(String args[]){
        TreeNode root = BinaryTree.createTree();
        MaximumPathSum ob = new MaximumPathSum();
        System.out.println(ob.maxPathSum(root));
    }
}
