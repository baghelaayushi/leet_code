import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.awt.*;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MergeLists {
    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
       if(A == null)
           return B;
       if(B== null)
           return A;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ListNode head1 = A;
        ListNode head2 = B;
        while(head1!=null){
            pq.add(head1.val);
            head1 = head1.next;
        }
        while(head2!=null){
            pq.add(head2.val);
            head2 = head2.next;
        }

        head1 = new ListNode(pq.remove());
        head2 = head1;

        while(!pq.isEmpty()){
            head1.next = new ListNode(pq.remove());
            head1 = head1.next;
        }

        return head2;

    }
    public static ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ListNode head1;
        for(ListNode ls: lists){
            head1 = ls;
            while(head1!=null){
                pq.add(head1.val);
                head1 = head1.next;
            }
        }

        head1 = new ListNode(pq.remove());
        ListNode head2 = head1;

        while(!pq.isEmpty()){
            head1.next = new ListNode(pq.remove());
            head1 = head1.next;
        }

        return head2;

    }
    public static void main(String args[]){
        ListNode head = new ListNode(5);
        ListNode first = new ListNode(8);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(4);
        ListNode fourth = new ListNode(11);
        ListNode fifth = new ListNode(15);
        head.next = first;
        first.next = second;
        second.next = null;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;
        ListNode B= mergeTwoLists(head,third);
        while (B!=null){
            System.out.print(B.val+"->");
            B=B.next;
        }

    }
}
