public class SymmetricBinaryTree {
    public static int isSymmetricUtil(TreeNode A,TreeNode B) {
        if (A == null && B == null)
            return 1;

        if(A==null && B!=null)
            return 0;

        if(B==null && A!=null)
            return 0;

        System.out.println(A.val + ","+B.val);

        /* first recur on left child */
        if(isSymmetricUtil(A.left,B.right) == 0)
            return 0;

        /* then print the data of node */
        if(A.val!=B.val)
            return 0;


        /* now recur on right child */
        if(isSymmetricUtil(A.right,B.left) == 0)
            return 0;

        return 1;
    }
    public static int isSymmetric(TreeNode A) {
        if(A==null)
            return 0;
        if(A.left==null || A.right == null || A.left.val !=A.right.val)
            return 0;

        return isSymmetricUtil(A.left,A.right);
    }

    public static void main(String args[]){
        System.out.println(isSymmetric(BinaryTree.createTree()));
    }
}
