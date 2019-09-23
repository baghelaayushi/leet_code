import java.util.*;

public class RottenOranges {
    static int count=0;
    static boolean[] visited;
    public static void BFS(HashMap<Integer,List<Integer>> hm, Queue<Integer> queue1){
        if(!queue1.isEmpty()){

            //visiting the first node in the queue
            Queue<Integer> queue2 = new LinkedList<>();
            while(!queue1.isEmpty()) {
                int node = queue1.remove();
                visited[node] = true;
                System.out.print(node + "+");

                //iterating over the nodes and adding the ones that are not visited to queue
                List<Integer> l = hm.get(node);
                for (int i : l) {
                    int n = i;
                    if (!visited[n]) {
                        visited[n] =true;
                        queue2.add(n);
                    }
                }
            }
            if(!queue2.isEmpty())
                count++;
            BFS(hm,queue2);

        }

    }
    public static HashMap<Integer, List<Integer>> makeGraph(int A[][]){
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        int x[][] = new int[A.length][A[0].length];
        int k = 3;
        for(int i=0;i<x.length;i++)
            for(int j=0;j<x[0].length;j++){
                x[i][j]=k;
                k++;
            }

        List<Integer> temp = new ArrayList<Integer>();
        hm.put(2,temp);

        for(int i=0;i<A.length;i++)
            for(int j=0;j<A[0].length;j++){
                if(A[i][j]!=0) {
                    if (A[i][j] == 2) {
                        visited[x[i][j]] = true;
                        temp = hm.get(2);
                        if (i - 1 != -1 && A[i - 1][j] != 0&& A[i - 1][j] != 2)
                            temp.add(x[i - 1][j]);
                        if (j - 1 != -1 && A[i][j - 1] != 0&& A[i][j - 1] != 2)
                            temp.add(x[i][j - 1]);
                        if (j + 1 != A[0].length && A[i][j + 1] != 0&& A[i][j + 1] != 2)
                            temp.add(x[i][j + 1]);
                        if (i + 1 != A.length && A[i + 1][j] != 0&& A[i + 1][j] != 2)
                            temp.add(x[i + 1][j]);
                        hm.replace(2, temp);
                    } else {
                        temp = new ArrayList<>();
                        if (i - 1 != -1 && A[i - 1][j] != 0 && A[i - 1][j] != 2)
                            temp.add(x[i - 1][j]);
                        if (j - 1 != -1 && A[i][j - 1] != 0 && A[i][j - 1] != 2 )
                            temp.add(x[i][j - 1]);
                        if (j + 1 != A[0].length && A[i][j + 1] != 0 && A[i][j + 1] != 2)
                            temp.add(x[i][j + 1]);
                        if (i + 1 != A.length && A[i + 1][j] != 0 && A[i + 1][j] != 2)
                            temp.add(x[i + 1][j]);

                        hm.put(x[i][j],temp);

                    }
                }
                else{
                    visited[x[i][j]] = true;
                }
            }
        return hm;
    }
    public static int solve(int [][]A){
        visited = new boolean[A.length*A[0].length+3];
        HashMap<Integer,List<Integer>> hm = makeGraph(A);
        for(Map.Entry<Integer,List<Integer>> m:hm.entrySet()){
            System.out.println(m.getKey()+" "+ m.getValue());
        }

        count=0;
        Queue<Integer> queue1 = new LinkedList<>();
        ((LinkedList<Integer>) queue1).add(2);
        BFS(hm,queue1);
        for(int i=2;i<visited.length;i++)
            if(!visited[i])
                return -1;
        return count;

    }
    public static void main(String args[]){
        int A[][] ={{2,1,1},{1,1,0},{1,0,2}};
        System.out.println(solve(A));
    }
}
