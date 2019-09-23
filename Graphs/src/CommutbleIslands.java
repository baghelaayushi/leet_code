import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommutbleIslands {
    public static int solve(int A, int[][] B) {
        List<HashMap<Integer, List<Integer>>> Disconnected = new ArrayList<>(A + 1);
        int j = 0;
        for (HashMap<Integer, List<Integer>> i : Disconnected) {
            i = new HashMap<>();
            List<Integer> temp = new ArrayList<>();
            i.put(j, temp);
            j++;
        }

        return 0;

    }
    public static void main(String args[]){
        int A[][] = {{1,2,1},{2,3,4},{1,4,3},{4,3,2},{1,3,10}};
        System.out.println(solve(4,A));
    }
}
