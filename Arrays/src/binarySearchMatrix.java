import java.util.ArrayList;

public class binarySearchMatrix {
    ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    public int searchMatrixUtil(int b, int l, int r) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            int j = mid%arr.get(0).size();
            int i = mid/arr.get(0).size();
            //System.out.println(mid);
            //System.out.println(i+"  "+j);

            // If the element is present at the middle
            // itself
            if (arr.get(i).get(j) == b)
                return 1;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr.get(i).get(j) > b)
                return searchMatrixUtil(b,l, mid - 1);

            // Else the element can only be present
            // in right subarray
            return searchMatrixUtil(b ,mid + 1, r);
        }

        // We reach here when element is not
        // present in array
        return 0;

    }
    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        arr = a;
        int n = a.size()*a.get(0).size();
        //System.out.println(n);
        return searchMatrixUtil(b,0,n-1);
    }
    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(3);
        temp.add(5);
        temp.add(7);

        a.add(temp);
        temp = new ArrayList<>();
        temp.add(10);
        temp.add(11);
        temp.add(16);
        temp.add(20);

        a.add(temp);
        temp = new ArrayList<>();
        temp.add(23);
        temp.add(30);
        temp.add(34);
        temp.add(50);

        a.add(temp);

        binarySearchMatrix ob = new binarySearchMatrix();
        System.out.println(ob.searchMatrix(a,10));

    }
}
