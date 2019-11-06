public class LinkedListIntersection {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        if(a==null)
            return b;
        if(b== null)
            return a;
        int a_count =0;
        int b_count = 0;
        ListNode head_a = a;
        ListNode head_b = b;
        while(head_a!=null){
            a_count++;
            head_a = head_a.next;
        }
        while(head_b!=null){
            b_count++;
            head_b = head_b.next;
        }
        head_a = a;
        head_a = b;

        if(a_count>=b_count){
            int diff = a_count - b_count;
            int x =0;
            while(x<diff){
                head_a = head_a.next;
                x++;
            }
        }
        else{
            int diff = b_count - a_count;
            int x =0;
            while(x<diff){
                head_b = head_b.next;
                x++;
            }
        }
        while (head_a!=null &&head_b!=null){
            if(head_a.val == head_b.val)
                return head_a;

            head_a = head_a.next;
            head_b = head_b.next;
        }

        return head_a;

    }
}
