import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    static int[] preorderWithoutRecursion(TreeNode A){
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.add(A);
        while (!st.empty()){
            A = st.pop();
            output.add(A.val);

            if(A.right !=  null)
                st.push(A.right);

            if(A.left !=  null)
                st.push(A.left);

        }

        int[] o = new int[output.size()];
        int j=0;
        for(int i:output) {
            o[j] = i;
            j++;
        }

        System.out.println(output);

        return o;
    }

    public static void main(String[] args){
        lst.clear();
        TreeNode root = BinaryTree.createTree();
        //preOrder(root);
        //System.out.println(lst);
        preorderWithoutRecursion(root);
    }
}
