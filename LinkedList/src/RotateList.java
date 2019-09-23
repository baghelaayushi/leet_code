public class RotateList {
    public ListNode rotateRight(ListNode A, int B) {
        int count = 0 ;
        ListNode start = A,end = A;
        while(count<B){
            end = end.next;
            count++;
            if(end == null){
                B = B%count;
                count =0;
                end = A;
            }
        }

        while(end.next!=null){
            start = start.next;
            end =  end.next;
        }
        end.next = A;
        A = start.next;
        start.next = null;
        return A;
    }
    public static void main(String args[]){
        ListNode a = CreateNode.makeNode();
        RotateList ob = new RotateList();
        a = ob.rotateRight(a,6);
        while(a!=null){
            System.out.println(a.val);
            a = a.next;
        }
    }
}
