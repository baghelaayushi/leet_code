import java.util.Stack;
import java.util.TreeMap;

public class KSmallestElement {

    public static int kthsmallest(TreeNode A, int B) {
        int k = B;
        Stack<TreeNode> str = new Stack<>();
        TreeNode root = A;
        while(true){
            while (root!=null) {
                str.push(root);
                root = root.left;
            }

            root = str.pop();
            k--;
            if(k ==0)
                return root.val;

            root = root.right;
        }
    }
    public static void main(String args[]){
        System.out.println(kthsmallest(CreateTree.createTree(),3));
    }
}
