public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode A) {
        if(A==null)
            return null;

        ListNode head = A;
        while(head.next!=null){
            if(head.next.val == head.val)
                head.next = head.next.next;
            else{
                head= head.next;
            }
        }

        return A;
    }
    public ListNode deleteDuplicates1(ListNode A) {
        if(A==null)
            return null;

        ListNode head = A;
        while(head!=null&& head.next!=null){
            if(head.next.val == head.val){
                while(head.next!=null && head.next.val == head.val)
                    head.next = head.next.next;
                if(head.next!=null){
                    head.val = head.next.val;
                    head.next = head.next.next;
                }
                else {
                    ListNode X = A;
                    if(X == head)
                        return null;
                    while(X.next!=null && X.next!=head){
                        X = X.next;
                    }
                    X.next = null;
                    head = null;
                }
            }
            else{
                head= head.next;
            }
        }

        return A;
    }
    public static void main(String args[]){
        RemoveDuplicates ob = new RemoveDuplicates();
        ListNode n = ob.deleteDuplicates1(CreateNode.makeNode());
        while(n!=null){
            System.out.println(n.val);
            n = n.next;
        }
    }
}
