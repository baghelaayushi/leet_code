public class FindMiddle {
    public static int solve(ListNode A) {
        if(A == null)
            return 0;
        if(A.next == null)
            return A.val;
        int count = 1;
        int x = count;
        ListNode temp= A;
        while(temp!=null){
            int counter = (count*2)-1;
            while(x<counter){
                temp = temp.next;
                x++;
            }
            if(temp.next == null)
                return A.val;
            else{
                temp = temp.next;
                x++;
            }
            if(temp.next == null)
                return A.next.val;

            A = A.next;
            count++;
        }
     return 0;
    }
    public static void main(String args[]){
        ListNode head = CreateNode.makeNode();
        System.out.println(solve(head));
    }
}
