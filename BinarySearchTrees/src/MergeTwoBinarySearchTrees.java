import java.util.ArrayList;
import java.util.List;

public class MergeTwoBinarySearchTrees {
    List<Integer> temp;
    public void inOrder(TreeNode root){
        if(root == null)
            return;

        inOrder(root.left);

        temp.add(root.val);

        inOrder(root.right);

    }
    public List<Integer> merge(List<Integer> A,List<Integer> B){
        List<Integer> output = new ArrayList<>(A.size()+B.size());
        int firstPointer = 0,secondPointer = 0;
        while(firstPointer<A.size() && secondPointer <B.size()){
            if(A.get(firstPointer)<=B.get(secondPointer)){
                output.add(A.get(firstPointer));
                firstPointer++;
            }
            else {
                output.add(B.get(secondPointer));
                secondPointer++;
            }
        }


        while (firstPointer<A.size()){
            output.add(A.get(firstPointer));
            firstPointer++;
        }

        while (secondPointer<B.size()){
            output.add(B.get(secondPointer));
            secondPointer++;
        }

        return output;
    }
    public int[] solve(TreeNode A, TreeNode B) {
        temp = new ArrayList<>();
        inOrder(A);
        List<Integer> firstTreeTraversal = temp;
        temp = new ArrayList<>();
        inOrder(B);
        List<Integer> secondTreeTraversal = temp;

        List<Integer> output = merge(firstTreeTraversal,secondTreeTraversal);
        int arr[] = new int[output.size()];
        int j =0;
        for(int i: output){
            arr[j] = i;
            j++;
        }
        return arr;
    }
}
