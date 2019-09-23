public class BeutifulStrings {
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
    public static int solve(String A) {
        int N = A.length();

        int max = Integer.MIN_VALUE;

        for(int i =1;i<N;i++){
            X = A.substring(0,i);
            Y = A.substring(i,N);

            arr= new int[X.length()][Y.length()];
            int x = solveUtil(X.length()-1,Y.length()-1);
            //System.out.println(x);
            max = Integer.max(x,max);
        }

        return max*2;
    }

    public static void main(String args[]){
        System.out.println(solve("abcdefghijklmnopqrstuvwxyywvutsrqpomnlkjihgfedcba"));

    }
}
