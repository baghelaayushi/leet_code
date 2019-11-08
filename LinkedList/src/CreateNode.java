public class CreateNode {
    public static ListNode makeNode(){
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(2);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(4);
        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;
        return head;
    }
}
