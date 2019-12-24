import java.util.ArrayList;
import java.util.List;

public class AllNodesDisatnceK {
    List<Integer> output = new ArrayList<>();
    public int findNode(TreeNode root,TreeNode target, int distance){
        if(root == target){
            return distance;
        }
        if(root == null)
            return -1;

        int leftDistance = findNode(root.left,target,distance+1);
        int rightDistance = findNode(root.right,target,distance+1);
        if(leftDistance == -1 && rightDistance ==-1)
            return -1;
        if(leftDistance>=0)
            return leftDistance;
        if(rightDistance>=0)
            return rightDistance;

        return -1;
    }
    public void BFS(){

    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        int distance = findNode(root,target,0);
        if(K == distance){
            //do a BFS from root
        }
        else if(K > distance){
            //go from root to K-distance
            //do a BFS
        }

        else {
            // go from root to K-distance in same direction of the node
            // do a BFS
        }

        return new ArrayList<>();

    }
}
