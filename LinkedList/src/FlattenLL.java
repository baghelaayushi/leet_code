import java.util.PriorityQueue;
class ListNode2 {
    int val;
    ListNode2 right, down;
    ListNode2(int x) {
        val = x;
        right = down = null;
    }
}

public class FlattenLL {
    ListNode flatten(ListNode2 root) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ListNode2 head1;
        ListNode2 head = root;
        while(head!=null){
            head1 = head;
            while(head1!=null){
                pq.add(head1.val);
                head1 = head1.down;
            }
            head = head.right;
        }

        ListNode output = new ListNode(pq.remove());
        ListNode temp = output;

        while(!pq.isEmpty()){
            temp.next = new ListNode(pq.remove());
            temp = temp.next;
        }

        return output;

    }
}
