public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        if(A==null)
            return null;

        ListNode fastPointer = A;
        int count = 1;
        while (fastPointer != null && count<=B){
            fastPointer = fastPointer.next;
            count++;
        }
        if(fastPointer == null)
            return A.next;
        ListNode slowPointer = A;
        while (fastPointer.next!=null){
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        slowPointer.next = slowPointer.next.next;
        return A;

    }
    public static void main(String args[]){
        ListNode node = CreateNode.makeNode();
        RemoveNthNodeFromEnd ob = new RemoveNthNodeFromEnd();
        ListNode output = ob.removeNthFromEnd(node,7);
        while(output!=null){
            System.out.println(output.val);
            output = output.next;
        }
    }
}
