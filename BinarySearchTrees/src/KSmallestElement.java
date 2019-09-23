public class KSmallestElement {
    static int count;
    static TreeNode root;
    public static int kthsmallestUtil(TreeNode A, int B) {
        if(A==null)
            return 0;

        int count_left = kthsmallestUtil(A.left,B);
        int count_right = kthsmallestUtil(A.right,B);
        if(count_left ==-1 || count_right ==-1)
            return -1;

        if(count_left == B) {
            root = A.left;
            return -1;
        }
        //System.out.print(count);

        if(count_left+1 == B) {
            root = A;
            return -1;

        }

        //System.out.print(count);


        if(count_left + count_right + 1 == B) {
            root = A.right;
            return -1;
        }
        System.out.println(count_left + count_right + 1);

        return count_left+count_right+1;
    }
    public static int kthsmallest(TreeNode A, int B) {
        count =0;
        root = A;
        kthsmallestUtil(A,B);
        return root.val;
    }
    public static void main(String args[]){
        System.out.println(kthsmallest(CreateTree.createTree(),3));
    }
}
