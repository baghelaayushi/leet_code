//A class to create and view a binary tree
public class BinaryTree {

    //This method returns a Tree node root
    public static TreeNode createTree(){
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9);
        t.right = new TreeNode(20);
        t.left.left = new TreeNode(18);
        t.left.right = new TreeNode(16);
        t.right.left = new TreeNode(24);
        t.right.right = new TreeNode(32);
        return t;
    }

    // Displays tree using inorder Traversal
    public static void inorderViewTree(TreeNode t){
        if (t == null)
            return;

        /* first recur on left child */
        inorderViewTree(t.left);

        /* then print the data of node */
        System.out.print(t.val + " ");

        /* now recur on right child */
        inorderViewTree(t.right);
    }

    public static void main(String args[]){
        TreeNode tree = createTree();
        inorderViewTree(tree);
    }
}
