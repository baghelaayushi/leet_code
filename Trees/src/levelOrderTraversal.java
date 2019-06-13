import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class levelOrderTraversal {
    private static List<List<Integer>> level_list = new ArrayList<>();

    // this function takes a queue which contains tree nodes to parsed as inputs
    // and adds the left and right child of the node to the queue
    // which are then visited in the next recursive cycle

    public static Queue<TreeNode> levelOrder(Queue<TreeNode> queue) {
        //
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
            level_list.add(list1);
            levelOrder(queue);
        }
        return empty_queue;
    }

    public static void main(String[] args) {
        level_list.clear();
        TreeNode root = BinaryTree.createTree();
        if(root == null)
            System.out.println(new ArrayList());

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Queue<TreeNode> queue1 = levelOrder(queue);
        System.out.println(level_list);
    }

}
