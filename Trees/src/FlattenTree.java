public class FlattenTree {
    public TreeNode flattenUtil(TreeNode root) {
        if(root == null)
            return null;

        // storing last element on left side of the tree
        TreeNode left = flattenUtil(root.left);

        // storing last element on right side of the tree
        TreeNode right = flattenUtil(root.right);

        //if leaf node return the element itself
        if(left == null && right == null)
            return root;

        //if left child absent return the right child
        if(left == null)
            return right;

        //if right child absent add left child to right and return the last element
        if(right == null){
            root.right = root.left;
            root.left = null;
            return left;
        }

        //if both children present
        //adding right child to last element on left
        //making left the right child
        left.right = root.right;
        root.right = root.left;
        root.left = null;
        return right;

    }
    public void flatten(TreeNode root) {
        flattenUtil(root);
    }
}
