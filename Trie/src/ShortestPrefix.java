import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Trie{
    HashMap<Character,Trie> hs;
    boolean end;

    Trie(){
        hs = new HashMap<>();
        end = false;
    }
}
public class ShortestPrefix {
    static void add(Trie root, String s){
        Trie node = root;
        for(int i=0;i<s.length();i++){
            if(!(node.hs.containsKey(s.charAt(i)))) {
                Trie temp = new Trie();
                node.hs.put(s.charAt(i),temp);
                node = temp;
            }
            else{
                node = node.hs.get(s.charAt(i));
            }
        }

        node.end = true;

    }
    static void display(Trie root, String s){
        if(root.end){
            if(root.hs.size() !=0){
                Trie node = root;
                for(Map.Entry<Character, Trie> m:node.hs.entrySet()){
                    //System.out.print(m.getKey() + "->");
                    String temp = s;
                    s = s + m.getKey();
                    node = m.getValue();
                    display(node,s);
                    s = temp;
                }
            }
            System.out.println(s);
            return;
        }
        Trie node = root;
        for(Map.Entry<Character, Trie> m:node.hs.entrySet()){
            //System.out.print(m.getKey() + "->");
            String temp = s;
            s = s + m.getKey();
            node = m.getValue();
            display(node,s);
            s = temp;
        }

    }
    static String findPrefixUtil(Trie root, String s){
        // the fucntion checks the latest index for a string in which the hashmap only contains one value
        // if the hashmap has more than one value at any index, position value is reset to -1,
        // indicating that no unique path exists for the string for a given index
        int position =-1;
        Trie node = root;

        for(int i=0;i<s.length();i++){
            char c =s.charAt(i);
            if(node.end || node.hs.size()>=2)
                position = -1;
            else if(node.hs.size() == 1 && position ==-1) {
                position = i;
            }
            node = node.hs.get(c);
        }
        if(position ==-1 || (node.end && node.hs.size()!=0))
            return s;
        return s.substring(0,position);
    }
    static String[] findPrefix(String[] s) {
        Trie root = new Trie();
        for (String a : s)
            add(root, a);

        //display(root, "");

        String output[] = new String[s.length];
        int i = 0;
        for (String a : s) {
            output[i] = findPrefixUtil(root,a);
            i++;
        }

        return output;
    }
    public static void main(String args[]){
        String s1[] = {"z","dog","dove","duck"};
        String s[] = {"r","running"};
        String output[] = findPrefix(s);
        for(String k: output)
            System.out.println(k);
    }
}
