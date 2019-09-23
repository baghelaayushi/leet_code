public class ValidBST {
    // if x is zero that means that the subtree is left
    // else subtree is right
    /*public static int isValidBSTUtil(TreeNode A, int x){
        if(A.left==null&& A.right== null)
            return A.val;
        // lst is maximum value in left sub tree
        // rst is maximum value in right sub tree
        int lst,rst;
        if(A.left!=null && A.right!=null){
            lst = isValidBSTUtil(A.left,0);
            rst = isValidBSTUtil(A.right,1);
            if(lst == 0 || rst ==0)
                return 0;
            if(A.val > lst && A.val < rst){
                if(x==0)
                    return Integer.max(Integer.max(lst,rst),A.val);
                if(x==1)
                    return Integer.min(Integer.min(lst,rst),A.val);
            }
            return 0;
        }
        if(A.left == null) {
            rst = isValidBSTUtil(A.right, 1);
            if(rst==0)
                return 0;
            if (A.val < rst) {
                if (x == 0)
                    return Integer.max(rst, A.val);
                if (x == 1)
                    return Integer.min(rst, A.val);
            }
        }
        if(A.right == null){
            lst = isValidBSTUtil(A.left,0);
            if(lst == 0)
                return 0;
            if(A.val>lst) {
                if (x == 0)
                    return Integer.max(lst, A.val);
                if (x == 1)
                    return Integer.min(lst, A.val);
            }
            return 0;
        }
        return 0;
    }
    public static int isValidBST(TreeNode A) {
        if(A==null || (A.left ==null && A.right ==null))
            return 1;
        int lst,rst;
        if(A.left == null)
            lst = A.val-1;
        else
            lst = isValidBSTUtil(A.left,0);

        if(A.right == null)
            rst = A.val+1;
        else
            rst = isValidBSTUtil(A.right,1);
        System.out.println(lst +"  "+ rst);
        if(lst==0||rst==0 || A.val <= lst || A.val >= rst)
            return 0;

        return 1;
    }*/
    public static boolean isValidBSTUtil(TreeNode A, int min,int max){
        if(A==null)
            return true;

        if(A.val<min || A.val>max)
            return false;

        if(isValidBSTUtil(A.left,min,A.val) && isValidBSTUtil(A.right,A.val,max))
            return true;

        return false;

    }
    public static int isValidBST(TreeNode A) {
        if(isValidBSTUtil(A,Integer.MIN_VALUE,Integer.MAX_VALUE))
            return 1;

        return 0;
    }
    public static void main(String args[]){
        System.out.println(isValidBST(CreateTree.createTree()));
    }
}
