public class DistinctSubsequences {
    static int[][] arr;
    static String X,Y;
    public static int solveUtil(int i, int j){
        if(j == -1)
            return 1;

        if(i == -1)
            return 0;
        if(i<j)
            return 0;

        if(arr[i+1][j+1]!=0)
            return arr[i+1][j+1];
        if(X.charAt(i)!=Y.charAt(j)) {
            arr[i+1][j+1] = solveUtil(i-1,j);
            return arr[i+1][j+1];
        }
        arr[i+1][j+1] = solveUtil(i - 1, j - 1) + solveUtil(i - 1, j);
        return arr[i+1][j+1];

    }
    public static int numDistinct(String A, String B) {
        X = A;
        Y = B;
        arr= new int[A.length()+1][B.length()+1];
        return solveUtil(X.length()-1,Y.length()-1);
    }
    public static void main(String args[]){

        System.out.println(numDistinct("rabbbit","rabbit"));
        for (int[] i:arr) {
            for (int x: i)
                System.out.print(x+"  ");
            System.out.println();
        }
    }
}
