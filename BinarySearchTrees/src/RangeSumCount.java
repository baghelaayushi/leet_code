public class RangeSumCount {
    int sum =0;
    int count =0;
    public void rangeSumBSTUtil(TreeNode root, int L, int R) {
        if(root == null)
            return;

        if(root.val<L)
            rangeSumBSTUtil(root.right,L,R);
        else if(root.val>R)
            rangeSumBSTUtil(root.left,L,R);
        else {
            sum = sum + root.val;
            count++;
            rangeSumBSTUtil(root.left,L,root.val);
            rangeSumBSTUtil(root.right,root.val,R);
        }

    }
    public int rangeSumBST(TreeNode root, int L, int R) {
        sum = 0;
        count = 0;
        rangeSumBSTUtil(root,L,R);
        System.out.println(count);
        return sum;
    }

    public static void main(String[] args) {
        RangeSumCount ob = new RangeSumCount();
        System.out.println(ob.rangeSumBST(CreateTree.createTree(),4,8));
    }
}
