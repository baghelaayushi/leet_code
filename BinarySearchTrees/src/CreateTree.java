public class CreateTree {
    static TreeNode createTree(){
        TreeNode root = new TreeNode(5);
        TreeNode three = new TreeNode(3);
        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);
        TreeNode  one = new TreeNode(1);
        TreeNode nine = new TreeNode(9);
        TreeNode eight = new TreeNode(8);


        root.left = three;
        root.right = eight;
        three.left = one;
        three.right = four;
        eight.left = seven;
        eight.right =nine;


        return root;
    }

    // Displays tree using inorder Traversal
    static void inorderViewTree(TreeNode t){
        if (t == null)
            return;

        /* first recur on left child */
        inorderViewTree(t.left);

        /* then print the data of node */
        System.out.print(t.val + " ");

        /* now recur on right child */
        inorderViewTree(t.right);
    }

    public static void main(String[] args){
        TreeNode tree = createTree();
        inorderViewTree(tree);
    }
}
