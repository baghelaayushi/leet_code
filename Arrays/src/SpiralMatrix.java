import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int start_i = 0;
        int end_i = matrix.length-1;
        int start_j = 0;
        int end_j = matrix[0].length-1;
        List<Integer> lst = new ArrayList<>();
        int elements = matrix.length * matrix[0].length;
        boolean straight = true;
        while (lst.size() < elements){
            int i = start_i;
            int j = start_j;
            while(j<=end_j && matrix[i][j] != Integer.MIN_VALUE) {
                lst.add(matrix[i][j]);
                matrix[i][j] = Integer.MIN_VALUE;
                j++;
            }
            j--;
            i++;
            while(i<=end_i && matrix[i][j] !=Integer.MIN_VALUE) {
                lst.add(matrix[i][j]);
                matrix[i][j] = Integer.MIN_VALUE;
                i++;
            }
            i--;
            j--;
            while(j>=start_j &&  matrix[i][j] != Integer.MIN_VALUE){
                lst.add(matrix[i][j]);
                matrix[i][j] = Integer.MIN_VALUE;
                j--;

            }
            j++;
            i--;
            while(i>start_i &&  matrix[i][j] != Integer.MIN_VALUE){
                lst.add(matrix[i][j]);
                matrix[i][j] = Integer.MIN_VALUE;
                i--;
            }
             start_i = start_i+1;
            end_i = end_i -1;
            start_j = start_j+1;
            end_j = end_j -1;

            }

        return lst;
    }
    public static void main(String args[]){
        int arr[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(arr));
    }
}
