import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {

    static List<Integer> lst = new ArrayList<>();
    static void inorder(TreeNode A) {
        if (A == null)
            return;

        /* first recur on left child */
        inorder(A.left);

        /* then print the data of node */
        lst.add(A.val);

        /* now recur on right child */
        inorder(A.right);
    }
    static int[] inorderWithoutRecursion(TreeNode A){
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while (A!=null || !st.empty()){
            while(A!=null){
                st.push(A);
                A = A.left;
            }

            if(!st.empty()) {
                A = st.pop();
                output.add(A.val);
                A=A.right;
            }

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
        //inorder(root);
        //System.out.println(lst);

        inorderWithoutRecursion(root);
    }
}
