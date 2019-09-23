import java.util.Arrays;

public class PreorderInorderTree {
    private static int inorder[];
    private static int preorder[];

    static void makeTreeUtil(int iStart, int iEnd, int pStart, int pEnd, TreeNode node) {
        if (iEnd > iStart) {
            // the loop finds position of the current root element(the node) in inorder array
            int j;
            for (j = iStart; j <= iEnd; j++)
                if (inorder[j] == preorder[pStart])
                    break;

            // if no right subtree is present

            if(j ==  iEnd){
                node.left = new TreeNode(preorder[pStart+1]);
                makeTreeUtil(iStart , j-1, pStart+1, pStart+j, node.left);
                return;
            }

            // to no left subtree is present
            if(j== iStart){
                node.right = new TreeNode(preorder[pStart+j - iStart +1]);
                makeTreeUtil(j+1, iEnd, pStart+ j - iStart + 1, pEnd, node.right);
                return;
            }

            // this is the normal case when both subtrees are present for the current node
            // node values are assigned to left and right of current node
            // function is recursively caled for right and left subtree

            node.left = new TreeNode(preorder[pStart+1]);
            node.right = new TreeNode(preorder[pStart+j - iStart +1]);
            makeTreeUtil(iStart , j-1, pStart+1, pStart+j, node.left);
            makeTreeUtil(j+1, iEnd, pStart+ j - iStart + 1, pEnd, node.right);

        }
    }

    public static TreeNode buildTree(int[] p, int[] i) {
        if(i.length >0 && p.length >0){
            TreeNode root = new TreeNode(p[0]);
            inorder = i;
            preorder = p;
            makeTreeUtil(0,i.length-1,0,p.length-1, root);
            return root;}
        else
            return null;
    }

    public static void main(String[] args){
        int p[] = {8,5,9,7,1,12,2,4,11,3};
        int i[] = {9,5,1,7,2,12,8,4,3,11};
        TreeNode root =buildTree(p,i);
        BinaryTree.inorderViewTree(root);
    }
}
