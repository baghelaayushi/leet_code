// this class flattens the binary tree
public class FlatList {

    public static void printTree(TreeNode node){
        if(node.right != null){
            System.out.println(node.val + "->");
            printTree(node.right);
        }

    }
    public static TreeNode flatten(TreeNode node){
        if(node.left!=null){
            if(node.right != null){
                TreeNode temp = node.right;
                node.right = node.left;
                node.left = null;
                node = flatten(node.right);
                node.right = temp;
            }
            else{
                node.right = node.left;
                flatten(node.right);
            }
        }
        else if(node.right != null) {
            flatten(node.right);
        }
        return node;

    }
    public static void main(String[] args) {
        TreeNode root = BinaryTree.createTree();
        flatten(root);
        printTree(root);
    }

}
