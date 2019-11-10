import java.util.*;

class nodeVal{
    TreeNode node;
    int position;
    public nodeVal(TreeNode node,int position){
        this.node = node;
        this.position = position;
    }
}
public class VerticalOrderTraversal {
    TreeMap<Integer, List<Integer>> hm = new TreeMap<>();
    public void verticalOrderTraversalUtil(Queue<nodeVal> queue){
        if(!queue.isEmpty()){
            Queue<nodeVal> temp = new LinkedList<>();
            while (!queue.isEmpty()){
                nodeVal lst = queue.remove();
                if(hm.containsKey(lst.position)){
                    List<Integer> currentValues = hm.get(lst.position);
                    currentValues.add(lst.node.val);
                    hm.replace(lst.position,currentValues);
                }
                else {
                    List<Integer> currentValues = new ArrayList<>();
                    currentValues.add(lst.node.val);
                    hm.put(lst.position,currentValues);
                }
                if(lst.node.left!=null){
                    temp.add(new nodeVal(lst.node.left,lst.position-1));
                }
                if(lst.node.right!=null){
                    temp.add(new nodeVal(lst.node.right,lst.position+1));
                }

            }

            verticalOrderTraversalUtil(temp);

        }
    }
    public int[][] verticalOrderTraversal(TreeNode A) {
        hm = new TreeMap<>();
        Queue<nodeVal> queue = new LinkedList<>();
        queue.add(new nodeVal(A,0));
        verticalOrderTraversalUtil(queue);
        int[][] output = new int[hm.size()][];
        int j =0;
        for(Map.Entry<Integer,List<Integer>> m: hm.entrySet()){
            List<Integer> temp = m.getValue();
            int arr[] = new int[temp.size()];
            for(int i=0;i<temp.size();i++){
                arr[i] = temp.get(i);
            }
            output[j] = arr;
            j++;
        }
        return output;
    }
    public static void main(String args[]){
        VerticalOrderTraversal ob = new VerticalOrderTraversal();
        int[][] output = ob.verticalOrderTraversal(BinaryTree.createTree());
        for(int i[]:output) {
            for (int j : i)
                System.out.print(j);
            System.out.println();
        }
    }
}
