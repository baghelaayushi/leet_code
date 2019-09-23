import java.util.*;

/*public class Smallest0and1 {
    static HashMap<Integer, ArrayList<Integer>> hm;
    static String str;
    public static boolean multipleUtil(int A, String s, Queue<Integer> queue1){
        if(!queue1.isEmpty()){
            int m =  1000000007;
            int node = queue1.remove();
            int node1 =
            int j = Integer.parseInt(s) % m;
            if(j%A == 0) {
                str = s;
                return true;
            }
            ArrayList<Integer> temp = hm.get(node);
            for(int i: temp)
                queue1.add(i);

            if(multipleUtil(A,s+node))

        }
        multipleUtil(A,s,queue1);

    }
    public static String multiple(int A) {
        hm = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        al.add(0);
        al.add(1);
        hm.put(0,al);
        hm.put(1,al);
        str = "";
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        multipleUtil(A,"",queue);
        return str;
    }
    public static void main(String args[]){
        String s = "10";
        int i = Integer.parseInt(s);
        int x = 3;
        s = s+x;
        System.out.println(s);
        System.out.println(i%3);
        System.out.println(multiple(55));
    }
}
*/