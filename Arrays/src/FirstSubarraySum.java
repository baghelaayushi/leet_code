import java.util.Arrays;
public class FirstSubarraySum {
    static int[] solve(int A[], int B){
        int i=1, j= i+1;
        int temp[] = new int[A.length+1];
        temp[0] = 0;
        for(int k=1; k<temp.length;k++){
            temp[k] = temp[k-1]+A[k-1];
        }
        if(temp[temp.length-1] == B)
            return A;
        for(int k=0;k<temp.length;k++)
            System.out.println(temp[k]);
        while(i<temp.length) {
            if (j == temp.length - 1) {
                if (temp[j] - temp[i - 1] == B)
                    break;
                else
                    i++;
            } else {
                if (i == j) {
                    System.out.println(i);
                    if (temp[j] - temp[i - 1] == B)
                        break;
                    else
                        j++;
                } else if (i < j) {
                    if (temp[j] - temp[i - 1] > B)
                        i++;
                    else if (temp[j] - temp[i - 1] < B)
                        j++;
                    else {
                        break;
                    }
                }
            }
        }
        System.out.println(i+","+j);
        int output[] = {-1};
        int output1[] = Arrays.copyOfRange(A, i-1, j);
        if(temp[j] - temp[i-1] != B)
            return output;
        else
            return output1;

    }
    public static void main(String []args){
        int arr[] ={10,20,40,100};
        int x[] =solve(arr,5);
        System.out.println(x[0]);
    }
}
