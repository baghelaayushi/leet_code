public class BinaryTreeTilt {
    int sum =0;
    public int findTiltUtil(TreeNode root){
        if(root == null){
            return 0;
        }
        int left_sum = findTiltUtil(root.left);
        int right_sum = findTiltUtil(root.right);

        int temp_sum = left_sum+right_sum;
        int tilt = Math.abs(left_sum-right_sum);
        sum+=tilt;
        return temp_sum+root.val;
    }
    public int findTilt(TreeNode root){
        sum = 0;
        findTiltUtil(root);
        return sum;
    }
    public static void main(String args[]){
        BinaryTreeTilt ob = new BinaryTreeTilt();
        System.out.println(ob.findTilt(BinaryTree.createTree()));
    }


}
