import com.sun.source.tree.Tree;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumDifference {
    HashMap<TreeNode, List<TreeNode>> Ancestor = new HashMap<>();
    public void maxAncestorDiffUtil(TreeNode root,TreeNode parent) {
        if(root == null)
            return;

        if(Ancestor.containsKey(parent)){
            List<TreeNode> lst = new ArrayList<>(Ancestor.get(parent));
            lst.add(parent);
            Ancestor.put(root,lst);
        }
        maxAncestorDiffUtil(root.left,root);
        maxAncestorDiffUtil(root.right,root);


    }
    public int maxAncestorDiff(TreeNode root) {
        Ancestor = new HashMap<>();
        List<TreeNode> lst = new ArrayList<>();
        Ancestor.put(root,lst);
        maxAncestorDiffUtil(root.left,root);
        maxAncestorDiffUtil(root.right,root);
        int max = Integer.MIN_VALUE;
        for (Map.Entry<TreeNode,List<TreeNode>> mp: Ancestor.entrySet()){
            int child = mp.getKey().val;
            for (TreeNode t:mp.getValue()){
                if(Math.abs(t.val - child) > max)
                    max = Math.abs(t.val-child);
                //System.out.println(max);
            }
        }
        return max;

    }

    public static void main(String[] args) {
        TreeNode root = BinaryTree.createTree();
        MaximumDifference ob  = new MaximumDifference();
        System.out.println(ob.maxAncestorDiff(root));
    }
}
