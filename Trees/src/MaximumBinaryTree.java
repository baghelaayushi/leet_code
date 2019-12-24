public class MaximumBinaryTree {
    public int calcuMax(int l, int r, int[] nums){
        int max = l;
        for(int i = l;i<r;i++){
            if(nums[i] > nums[max]){
                max = i;
            }
        }
        return max;
    }
    public TreeNode constructMaximumBinaryTreeUtil(int[] nums, int l, int r) {
        if(l==r)
            return null;
        int max = calcuMax(l,r,nums);
        TreeNode node = new TreeNode(nums[max]);
        node.left = constructMaximumBinaryTreeUtil(nums,l, max);
        node.right = constructMaximumBinaryTreeUtil(nums, max+1,r);
        return node;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTreeUtil(nums, 0, nums.length);
    }
    public static void main(String args[]){
        MaximumBinaryTree ob = new MaximumBinaryTree();
        int arr[] = {3,2,1,6,0,5};
        TreeNode root = ob.constructMaximumBinaryTree(arr);
        BinaryTree.inorderViewTree(root);
    }
}
