public class BalancedBinaryTree {
    static boolean diff = true;
    public static int isBalancedUtil(TreeNode A) {
        if (diff) {
            if (A==null)
                return 0;
            int left_height;
            int right_height;
            int height;

            if (A.right == null) {
                left_height = isBalancedUtil(A.left);
                right_height = -1;
                height = left_height + 1;
            } else if (A.left == null) {
                right_height = isBalancedUtil(A.right);
                left_height = -1;
                height = right_height + 1;
            } else {
                left_height = isBalancedUtil(A.left);
                right_height = isBalancedUtil(A.right);
                height = 1 + Math.max(left_height, right_height);
            }

            int height_diff;
            height_diff = right_height - left_height;

            if (height_diff < 0)
                height_diff = -height_diff;

            if (height_diff >= 2)
                diff = false;

            System.out.println(A.val + "," + left_height + "," + right_height + "," + height);
            return height;

        }
        return -1;
    }
    public static void main(String args[]){
      System.out.println(isBalancedUtil(BinaryTree.createTree()));
      System.out.println(diff);
    }
}
