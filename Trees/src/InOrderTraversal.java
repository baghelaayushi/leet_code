import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {

    static List<Integer> lst = new ArrayList<>();
    static void inorder(TreeNode root) {
        if (root == null)
            return;

        /* first recur on left child */
        inorder(root.left);

        /* then print the data of node */
        lst.add(root.val);

        /* now recur on right child */
        inorder(root.right);
    }

    public static void main(String[] args){
        lst.clear();
        TreeNode root = BinaryTree.createTree();
        inorder(root);
        System.out.println(lst);
    }
}
