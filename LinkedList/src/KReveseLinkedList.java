public class KReveseLinkedList {
    public ListNode reverseList(ListNode A, int B) {
        ListNode head = A;
        ListNode head1 = head;
        ListNode temp;
        int count = 1;
        while(head!=null){
            temp = head.next;
            ListNode start = head;
            start.next = null;
            for(int i=1;i<B;i++){
                ListNode temp1 = temp.next;
                temp.next = head;
                head = temp;
                temp = temp1;
            }

            if(count == 1) {
                A = head;
            }
            else{
                head1.next = head;
                head1 = start;
            }

            //System.out.println(count);
            count++;
            head = temp;
        }

        return A;

    }
    public static void main(String args[]){
        KReveseLinkedList ob = new KReveseLinkedList();
        ListNode output = ob.reverseList(CreateNode.makeNode(),0);
        while(output!=null){
            System.out.println(output.val);
            output = output.next;
        }
    }
}
