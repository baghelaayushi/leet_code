import java.util.List;

public class NodeFromEnd {
    public static ListNode removeNthFromEnd(ListNode A, int B) {
        if(A == null)
            return null;
        ListNode temp = A;
        ListNode temp2 = A;
        int i=1;
        while(i < B) {
            if (temp.next == null)
                return null;
            else {
                temp = temp.next;
                i++;
            }
        }
        System.out.println(temp.val);
        while (temp.next != null  && A.next != null){
            temp = temp.next;
            A = A.next;
        }

        if(A == null || A.next == null)
            return temp2;
        else{
            A.next = A.next.next;
        }
        System.out.println(A.val);
        return temp2;
    }
    public static void main(String args[]){
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(4);
        ListNode fourth = new ListNode(5);
        ListNode fifth = new ListNode(6);
        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;
        ListNode a =removeNthFromEnd(head, 6);
        while (a!=null){
            System.out.print(a.val + "->");
            a= a.next;
        }
  }
}
