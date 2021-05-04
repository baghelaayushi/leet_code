//A class to create and view a binary tree
public class BinaryTree {

    //This method returns a Tree node root
    static TreeNode createTree(){
        TreeNode root = new TreeNode(8);
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        /*TreeNode nine = new TreeNode(9);
        TreeNode seven = new TreeNode(7);
        TreeNode one = new TreeNode(1);
        TreeNode twelve = new TreeNode(12);
        TreeNode two = new TreeNode(2);
        TreeNode eleven = new TreeNode(11);
        TreeNode three = new TreeNode(3);*/

        root.left = five;
        root.right = four;
        five.left = new TreeNode(3);
        five.left.left = new TreeNode(2);
        /*five.left = nine;
        five.right = seven;
        seven.left = one;
        seven.right = twelve;
        twelve.left = two;
        four.right = eleven;
        eleven.left = three;*/

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
