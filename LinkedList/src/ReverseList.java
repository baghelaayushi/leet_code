public class ReverseList {
    public static ListNode reverseBetween(ListNode A, int B, int C) {
     if(A == null || A.next == null || B == C )
         return A;
     int count = 1;
     ListNode temp = A;
     while(count<B-1){
         temp = temp.next;
         count++;
     }
     //System.out.println(count);
     //System.out.println(temp.val);
     ListNode temp1;
     if(B==1)
         temp1 = temp;
     else {
         temp1 = temp.next;
         count++;
     }
     //System.out.println(temp1.val);
     ListNode temp2 = temp1.next;
     ListNode temp3 = temp2.next;
     while(temp2!= null && count<C){
         temp2.next = temp1;
         temp1 = temp2;
         temp2 = temp3;
         if(temp3 != null)
             temp3 = temp3.next;
         count++;
     }
     if(B==1) {
         temp.next = temp2;
         return temp1;
     }
     temp.next.next = temp2;
     temp.next = temp1;

     return A;


    }
    public static void main(String args[]){
        ListNode head = CreateNode.makeNode();
        ListNode a = reverseBetween(head,4,5);
        while (a!=null){
            System.out.print(a.val + "->");
            a= a.next;
        }
    }
}
