class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class SortedListToBST {
    static ListNode h;
    public TreeNode sortedListToBSTUtil(int l, int r) {
        if(l>r)
            return null;
        int mid = l+(r-l)/2;
        ListNode head1 = h;

        for(int i=0;i<mid;i++)
            head1 = head1.next;

        TreeNode root = new TreeNode(head1.val);
        if(l== mid)
            root.left = null;
        else
            root.left = sortedListToBSTUtil(l,mid-1);

        if(r== mid)
            root.right = null;
        else
            root.right = sortedListToBSTUtil(mid+1,r);

        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        h= head;
        ListNode head1 = head;
        int count =0;
        while(head1.next!=null) {
            count++;
            head1 = head1.next;
        }
        return sortedListToBSTUtil(0,count);
    }
    public static void main(String args[]){
        ListNode head = new ListNode(-10);
        ListNode one = new ListNode(-3);
        ListNode two = new ListNode(0);
        ListNode three = new ListNode(5);
        ListNode four = new ListNode(9);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        SortedListToBST ob = new SortedListToBST();
        TreeNode n = ob.sortedListToBST(head);
        CreateTree.inorderViewTree(n);
    }

}
