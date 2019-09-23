public class SubMtrixSum {
    public int solveUtil(int[][] A, int[] B, int[] C){
        int sum=0;
        for(int i = B[0];i<=C[0];i++){
            for(int j=B[1];j<=C[1];j++){
                int top_left = (i-B[0]+1)*(j-B[1]+1);
                int bottom_right = (C[0]-i)*(C[1]-j);
                sum+= top_left*bottom_right*A[i][j];
            }
        }

        return sum;
    }
    public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int output[] = new int[B.length];
        for(int i=0;i<B.length;i++) {
            int top_left[] = {B[i]-1,C[i]-1};
            int bottom_right[] = {D[i]-1,E[i]-1};
            output[i] = solveUtil(A, top_left,bottom_right);
        }
        return output;
    }
    public static void main(String args[]){
        SubMtrixSum ob = new SubMtrixSum();
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        int B[] = {1,2};
        int C[] = {1,2};
        int D[] = {2,3};
        int E[] = {2,3};
        int output[] = ob.solve(A,B,C,D,E);
        for(int i:output)
            System.out.println(i);

    }
}
