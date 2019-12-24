import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftView {
    List<Integer> output = new ArrayList<>();
    public void solveUtil(Queue<TreeNode> queue){
        if(!queue.isEmpty()){
            Queue<TreeNode> queue1 = new LinkedList<>();
            TreeNode current = queue.remove();
            output.add(current.val);
            if(current.left!=null)
                queue1.add(current.left);
            if(current.right!=null)
                queue1.add(current.right);
            while (!queue.isEmpty()){
                current = queue.remove();
                if(current.left!=null)
                    queue1.add(current.left);
                if(current.right!=null)
                    queue1.add(current.right);
            }
            solveUtil(queue1);
        }
    }
    public int[] solve(TreeNode A) {
        if(A== null)
            return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        solveUtil(queue);
        int x[] = new int[output.size()];
        for(int i =0;i<output.size();i++)
            x[i] = output.get(i);

        return x;
    }
}
