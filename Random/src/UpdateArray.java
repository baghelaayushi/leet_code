public class UpdateArray {
    public static int[] solve(int[] A) {
        int temp[] = A;
        for(int l = 0; l< A.length; l++){
            int countX = 0;
            int countY = 0;
            System.out.print(A[l]);
            for(int k = 0; k <= l-1;k++){
                if(A[l] == A[k]) {
                    countX = countX+1;
                }
            }
            System.out.print(countX);
            for(int m = l+1; m<= A.length-1;m++){
                if(A[m] == A[l]) {
                    countY++;
                }

            }
            System.out.print(countY);
            System.out.println();
            temp[l] = countY- countX;
        }
        return temp;
    }
    public static void main(String args[]){
        int nums[] = {1,2,3,2,1};
        nums= solve(nums);
        for (int i=-0;i<nums.length;i++)
            System.out.println(nums[i]);
    }
}
