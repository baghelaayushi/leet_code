import java.util.HashSet;
import java.util.Iterator;

class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
}
public class CopyList {
    public static RandomListNode copyRandomList(RandomListNode head) {
        HashSet<Integer> h = new HashSet<>();
        if(head == null)
            return null;
        RandomListNode node = head;

        while(node!= null){
            while(head!=null){
                if(!h.contains(head.label))
                    h.add(head.label);
                head = head.next;
            }
            node = node.random;
            head = node;
        }

        Iterator<Integer> i = h.iterator();
        RandomListNode output = new RandomListNode(i.next());
        RandomListNode output1 = output;
        while (i.hasNext()){
            output.next = new RandomListNode(i.next());
            output = output.next;
        }

        output = null;
        return output1;
    }
    public static void main(String args[]){
        RandomListNode n = new RandomListNode(1);
        RandomListNode n1 = new RandomListNode(2);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(1);
        RandomListNode n4 = new RandomListNode(3);
        RandomListNode n5 = new RandomListNode(1);

        n.next = n1;
        n1.next = null;
        n.random= n2;
        n2.next = n3;
        n3.next = null;
        n2.random = n4;
        n4.next = n5;
        n5.next = null;
        n4.random = null;

        RandomListNode node = n;
        RandomListNode node1 = n;

        while(node!= null){
            while(n!=null){
                System.out.print(n.label + "->");
                n = n.next;
            }
            node = node.random;
            n = node;
            System.out.println();
        }


        RandomListNode x = copyRandomList(node1);
        while(x!=null){
            System.out.print(x.label+ "->");
            x= x.next;
        }
    }
}
