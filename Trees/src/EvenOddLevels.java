import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EvenOddLevels {
    private static List<List<Integer>> odd_level_list = new ArrayList<>();
    private static List<List<Integer>> even_level_list = new ArrayList<>();
    static int level = 0;

    public static Queue<TreeNode> levelOrder(Queue<TreeNode> queue) {
        //
        level++;
        Queue<TreeNode> empty_queue = new LinkedList<TreeNode>();
        System.out.println(queue.size());
        if((queue.size() != 0) && (queue.peek() != null)) {
            List<Integer> list1 = new ArrayList<Integer>();
            int size = queue.size();
            while(size!=0) {
                size--;

                // first item in the queue is removed
                // the left and children are added respectively if they exist

                TreeNode node = queue.remove();
                list1.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            // the list in each recursion is added to the global list

            if(level%2==0)
                even_level_list.add(list1);
            else
                odd_level_list.add(list1);
            levelOrder(queue);
        }
        return empty_queue;
    }
    public static void main(String args[]){
        odd_level_list.clear();
        even_level_list.clear();
        TreeNode root = BinaryTree.createTree();
        if(root == null)
            System.out.println(new ArrayList());

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<TreeNode> queue1 = levelOrder(queue);
        int sum_even=0;
        for(List<Integer> x:even_level_list)
            for (int y:x)
                sum_even+= y;

        int sum_odd=0;
        for(List<Integer> x:odd_level_list)
            for (int y:x)
                sum_odd+= y;

            System.out.println(odd_level_list);
            System.out.println(even_level_list);
        System.out.println(sum_odd + ","+sum_even);
        System.out.println(sum_odd - sum_even);
    }
}
