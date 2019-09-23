public class SwapNodes {
    public static ListNode swapPairs(ListNode A) {
        if(A == null || A.next == null)
            return A;
        ListNode temp1 = A;
        ListNode temp2 = temp1.next;
        ListNode temp;
        temp = temp2.next;
        A = temp2;
        temp2.next = temp1;
        temp1.next = temp;

        temp = temp1;
        temp1 = temp1.next;
        if(temp1!=null)
            temp2 = temp1.next;
        else
            temp2 = temp1;
        while(temp2!=null){
            temp1.next = temp2.next;
            temp2.next = temp1;
            temp.next = temp2;

            temp = temp1;
            temp1 = temp1.next;
            if(temp1 != null)
                temp2 = temp1. next;
            else
                temp2 = temp1;
        }
        return A;
    }
    public static void main(String args[]){
        ListNode a = swapPairs(CreateNode.makeNode());
        while (a!=null){
            System.out.print(a.val + "->");
            a= a.next;
        }
    }
}
