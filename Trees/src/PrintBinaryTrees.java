import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTrees {

    int level = 0;
    List<List<String>> lst;

    public void findLevel(TreeNode root, int current){
        if(root == null)
            return;

        if(current > level)
            level = current;

        findLevel(root.left,current+1);
        findLevel(root.right,current+1);

    }

    public void fillValues(TreeNode root, int row, int start, int end, int total){
        if(root == null)
            return;

        if(lst.size()-1<row)
            lst.add(new ArrayList<>(total));

        List<String> l = lst.get(row);
        if(l.size() == 0)
            for(int i =0;i<total;i++)
                l.add("");
        l.set((start+end)/2,String.valueOf(root.val));
        lst.set(row,l);
        fillValues(root.left,row+1,start,(start+end)/2-1,total);
        fillValues(root.right,row+1,(start+end)/2+1,end,total);


    }

    public List<List<String>> printTree(TreeNode root) {
        level = 0;
        int count = 0;
        findLevel(root,0);
        for(int i = 0;i<level;i++)
            count += Math.pow(2,i);

        int totalElements = (int)(Math.pow(2,level) + count);

        lst = new ArrayList<>(level+1);

        fillValues(root,0,0,totalElements,totalElements);

        //System.out.println(level);
        //System.out.println(count);
        //System.out.println(totalElements);
        System.out.println(lst);
        return null;
    }

    public static void main(String[] args) {
        PrintBinaryTrees ob = new PrintBinaryTrees();
        ob.printTree(BinaryTree.createTree());
    }
}
