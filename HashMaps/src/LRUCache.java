import java.util.HashMap;

class Node{
    Node prev;
    Node next;
    int value;
    public Node(int value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }

}
public class LRUCache {
    Node head;
    Node tail;
    HashMap<Integer, Node> nodeMap;
    int capacity;

    public LRUCache(int capacity) {
        head = null;
        tail = null;
        nodeMap = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!nodeMap.containsKey(key))
            return -1;

        Node node = nodeMap.get(key);
        remove(node);
        add(node);

        return node.value;

    }

    public void put(int key, int value) {
        if(nodeMap.containsKey(key)){
            remove(nodeMap.get(key));
            add(nodeMap.get(key));
        }
        if(nodeMap.size()>=capacity){
            System.out.println("capacity exceeded....removing...");
            System.out.println(head.value);
            nodeMap.remove(head.value);
            head = head.next;
            head.prev = null;
            Node node = new Node(value);
            add(node);
            nodeMap.put(key,node);
        }
        else {
            Node node = new Node(value);
            add(node);
            nodeMap.put(key,node);
        }

    }

    public void add(Node node){
        if(head == null) {
            head = node;
            tail = head;
        }
        else {
            node .prev = tail;
            tail.next = node;
            tail = node;
        }

    }


    public void remove(Node node){
        if(node == head){
            head = head.next;
        }
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node = null;
        }
    }

    public static void main(String args[]){
        LRUCache obj = new LRUCache(4);
        obj.put(1,1);
        obj.put(2,2);
        obj.put(3,3);
        obj.put(4,4);
        System.out.println(obj.get(1));
        obj.put(5,5);
    }
}
