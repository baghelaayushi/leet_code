import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
class TrieNode{
    TrieNode zero;
    TrieNode one;
    boolean end;

    TrieNode(){
        zero = null;
        one = null;
        end = false;
    }
}
public class MaxXOR {
    static void add(TrieNode root, String s){
        TrieNode node = root;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==0){
                if(node.zero==null){
                    TrieNode temp = new TrieNode();
                    node.zero = temp;
                    node = temp;
                }
                else{
                    node = node.zero;
                }
            }
            else {
                if(node.one==null){
                    TrieNode temp = new TrieNode();
                    node.one = temp;
                    node = temp;
                }
                else{
                    node = node.one;
                }
            }
        }
        node.end = true;
    }
    static void display(TrieNode root, String s){
        if(root== null){
            System.out.println(s);
            return;
        }
        TrieNode node = root;
        display(node.zero,s+"0");
        display(node.one,s+"1");

    }
    public static int solve(int[] A) {
        TrieNode root = new TrieNode();
        int x = Integer.toBinaryString(A[A.length-1]).length();
        for(int i:A) {
            String binary = Integer.toBinaryString(i);
            char repeat[] = new char[x-binary.length()];
            Arrays.fill(repeat,'0');
            String r = new String(repeat);
            add(root, binary+r);
        }
        display(root,"");
        return x;
    }
    public static void main(String args[]){
        int A[] = {8,16,24,30,128};
        Arrays.sort(A);
        System.out.println(solve(A));

    }
}
