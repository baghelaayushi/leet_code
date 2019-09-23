import javax.swing.tree.TreeCellRenderer;
import java.util.ArrayList;
import java.util.List;

public class SortedArrayToBST {
    static List<Integer> A;
    public static TreeNode sortedArrayToBSTUtil(int l, int r){
        if(A.size() ==1) {
            return new TreeNode(A.get(0));
        }
        int mid = l+ (r-l)/2;
        TreeNode root = new TreeNode(A.get(mid));
        if(l== mid)
            root.left = null;
        else
            root.left = sortedArrayToBSTUtil(l,mid-1);

        if(r== mid)
            root.right = null;
        else
            root.right = sortedArrayToBSTUtil(mid+1,r);

        return root;
    }
    public static TreeNode sortedArrayToBST(final List<Integer> a) {
        System.out.println(a);
        A=a;
        return sortedArrayToBSTUtil(0,A.size()-1);
    }
    public static void main(String args[]){
        List<Integer> a = new ArrayList<>();
        int arr[] = {1,3,4,5,7,8,9};
        for(int i:arr)
            a.add(i);

        CreateTree.inorderViewTree(sortedArrayToBST(a));
    }
}
