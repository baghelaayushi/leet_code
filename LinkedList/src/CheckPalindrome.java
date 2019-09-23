public class CheckPalindrome {
    // the below function returns a linked list
    // that is reversed from index B to C
    public static ListNode reverseBetween(ListNode A, int B, int C) {
        if(A == null || A.next == null)
            return A;
        if(B==C){
            int count =1;
            while(count < B){
                A = A.next;
                count++;
            }
            return A;
        }
        int count = 1;
        ListNode temp = A;
        // loop to reach to B-1
        while(count<B-1){
            temp = temp.next;
            count++;
        }
        //System.out.println(count);
        //System.out.println(temp.val);
        ListNode temp1;
        // if B is the start node
        if(B==1)
            temp1 = temp;
        else {
            temp1 = temp.next;
            count++;
        }
        //System.out.println(temp1.val);
        ListNode temp2 = temp1.next;
        ListNode temp3 = temp2.next;

        // looping from B to C and swapping apt Linked list nodes
        while(temp2!= null && count<C){
            temp2.next = temp1;
            temp1 = temp2;
            temp2 = temp3;
            if(temp3 != null)
                temp3 = temp3.next;
            count++;
        }
     /*if(B==1) {
         temp.next = temp2;
         return temp1;
     }
     temp.next.next = temp2;
     temp.next = temp1;*/

       // setting the next value of last pointer to be null
       temp.next.next = null;

       return temp1;


    }
    public static int lPalin(ListNode A) {
        if(A == null)
            return 0;
        if(A.next == null)
            return 1;
        ListNode temp =A;
        ListNode temp2 = A;
        int count = 1;
        //counting number of elements in the list
        while (A.next!=null){
            count++;
            A= A.next;
        }
        //System.out.println(count);
       ListNode x;
        // reversing elements from middle to end in the list
       if(count%2==0)
           x = reverseBetween(temp2,count/2 +1,count);
       else
           x = reverseBetween(temp2,count/2+2,count);


       System.out.println(x.val);
       int counter =0;
       // checking if the values are same for
        // x and temp(pointing towards start of list)
       while(x !=null){
           //System.out.println(counter);
           if(x.val != temp.val){
               counter = 0;
               break;
           }
           else{
               counter =1;
           }
           x= x.next;
           temp = temp.next;
       }
       return counter;
    }
    public static void main(String []args){
        System.out.println(lPalin(CreateNode.makeNode()));
    }
}
