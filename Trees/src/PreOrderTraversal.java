import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {
    static List<Integer> lst = new ArrayList<>();
    static void preOrder(TreeNode root) {
        if (root == null)
            return;

        /* first print the data of node */
        lst.add(root.val);

        /* then recur on left child */
        preOrder(root.left);


        /* now recur on right child */
        preOrder(root.right);
    }

    public static void main(String[] args){
        lst.clear();
        TreeNode root = BinaryTree.createTree();
        preOrder(root);
        System.out.println(lst);
    }
}
