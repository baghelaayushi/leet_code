public class InvertTree {
    public static TreeNode invertTree(TreeNode A) {
        if(A== null || (A.left==null&&A.right==null))
            return A;

        TreeNode temp = A.left;
        A.left = A.right;
        A.right = temp;

        TreeNode lst = invertTree(A.left);
        TreeNode rst = invertTree(A.right);

        return A;
    }
    public static void main(String args[]){
        BinaryTree.inorderViewTree(invertTree(BinaryTree.createTree()));
    }
}
