public class BuildTree {

    private static int inorder[];
    private static int preorder[];

    // A helper function to assign values to tree nodes at appropriate positions
    static void makeTreeUtil(int iStart, int iEnd, int pStart, int pEnd, TreeNode node) {
        if (iEnd > iStart) {
            // the loop finds position of the current root element(the node) in inorder array
            int j;
            for (j = iStart; j <= iEnd; j++)
                if (inorder[j] == preorder[pStart])
                    break;
            System.out.println(j);

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

    // the method returns tree node root

    static TreeNode makeTree(int i[],int p[]){
        if(i.length >0 && p.length >0){
            TreeNode root = new TreeNode(p[0]);
            inorder = i;
            preorder = p;
            makeTreeUtil(0,i.length-1,0,p.length-1, root);
            return root;}
        else
            return null;
    }

    public static void main(String args[]) {
        int i[] ={18,15,16,14,9,3,24,20,32};
        int p[] ={3,9,18,16,15,14,20,24,32};
        TreeNode root = makeTree(i,p);
        BinaryTree.inorderViewTree(root);
    }
}