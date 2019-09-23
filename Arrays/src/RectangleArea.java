public class RectangleArea {
    // the function returns number of possible rectangles
    // of different configurations possible
    // with possible area less than a given value
    public static int solve(int[] A, int B) {
        int i =0, j= A.length-1;
        int M = 1000000007;
        int count =0;

        // calculating the possible rectangles(i is not equal to j)
        while(i<j){
            if(A[i]*A[j]>=B)
                j--;
            else {
                System.out.println(i+"  "+j);
                count = (((j-i)%M)*2)%M;
                i++;
            }
        }
        System.out.println(count);

        //calculating squares
        for(int k=0; k<A.length;k++){
            if(Math.pow(A[k],2.0)<B){
                //System.out.println(A[k]);
                count++;
                count = count%M;
            }
        }

        System.out.println(26898800%M);

        return count%((10^9)+7);

    }
    public static void main(String args[]){
        int A[] ={1,2,3,4,5};
        System.out.println(solve(A,5));
    }
}
