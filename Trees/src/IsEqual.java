public class IsEqual {
    public static int isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null)
            return 1;

        if(A==null && B!=null)
            return 0;

        if(B==null && A!=null)
            return 0;

        /* first recur on left child */
        if(isSameTree(A.left,B.left) == 0)
            return 0;

        /* then print the data of node */
        if(A.val!=B.val)
            return 0;


        /* now recur on right child */
        if(isSameTree(A.right,B.right) == 0)
            return 0;

        return 1;
    }
    public static void main(String args[]){
        System.out.println(isSameTree(BinaryTree.createTree(),BinaryTree.createTree()));
    }
}
