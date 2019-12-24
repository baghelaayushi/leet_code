import java.util.ArrayList;
import java.util.List;

public class LCA {
    List<String> output = new ArrayList<>();
    public String lowestCommonAncestorUtil(TreeNode root,TreeNode p,TreeNode q,String s){
        if(root == null || output.size() ==2)
            return "";
        if(root == p || root == q)
            output.add(s);

        lowestCommonAncestorUtil(root.left,p,q,s+"1");
        lowestCommonAncestorUtil(root.right,p,q,s+"0");

        return "";

    }
    public TreeNode findNode(TreeNode root,String s){
        if(s.length() == 0)
            return root;

        if(s.charAt(0) == '1')
            return findNode(root.left,s.substring(1));

        else {
            return findNode(root.right,s.substring(1));
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        output = new ArrayList<>();
        lowestCommonAncestorUtil(root,p,q,"0");
        if(output.size() <2)
            return null;
        int length = Integer.min(output.get(0).length(),output.get(1).length());
        int i;
        for(i=0;i<length;i++){
            if(output.get(0).charAt(i)!=output.get(1).charAt(i)) {
                break;
            }
        }
        if(i-1==0)
            return root;
        System.out.println(output.get(0).substring(1,i));
        return findNode(root,output.get(0).substring(1,i));
    }

    public static void main(String args[]){
        TreeNode root = BinaryTree.createTree();
        TreeNode p = root.left.left;
        TreeNode q = root.left.right;
        LCA ob = new LCA();
        TreeNode node = ob.lowestCommonAncestor(root,p,q);
        System.out.println(node.val);
    }
}
