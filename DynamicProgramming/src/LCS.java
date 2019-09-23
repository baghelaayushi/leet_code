import java.util.Arrays;

public class LCS {
    static int[][] arr;
    static String X,Y;
    public static int solveUtil(int i, int j){
        if(i<0 || j < 0)
            return 0;
        if(arr[i][j]!=0)
            return arr[i][j];
        if(X.charAt(i)==Y.charAt(j))
            return 1+ solveUtil(i-1,j-1);

        arr[i][j] =  Integer.max(solveUtil(i,j-1),solveUtil(i-1,j));
        return arr[i][j];

    }
    public static int solve(String A, String B) {
        X = A;
        Y = B;
        arr= new int[A.length()][B.length()];
        return solveUtil(X.length()-1,Y.length()-1);
    }
    public static void main(String args[]){
        System.out.println(solve("abcdefgh","ijklmnopqrstuvwxyywvutsrqpomnlkjihgfedcba"));
    }
}
