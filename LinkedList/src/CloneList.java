class ListNode1 {
    int val;
    ListNode1 next, random;
    ListNode1(int x) {
        val = x;
        next = random = null;
    }
}
public class CloneList {
    ListNode1 cloneList(ListNode1 A) {
        if(A == null)
            return null;

        ListNode1 head= A;
        while(head!= null){
            ListNode1 node = new ListNode1(head.val);
            node.next = head.next;
            head.next = node;
            head = head.next.next;
        }

        head = A;

        while(head!=null){
            head.next.random = head.random.next;
            head = head.next.next;
        }

        head = A.next;
        while (head.next!=null){
            head.next = head.next.next;
        }

        return A.next;


    }
}
