// the following class returns the number of pairs with a particular sum in an array
public class PairSum {
    static int solve(int A[], int B){
        int count =0, i=0, j= A.length-1;
        System.out.println(A.length);
        while(i<j){
            if(A[i]+A[j]>B)
                j--;
            else if(A[i]+A[j]<B)
                i++;
            else{
                System.out.println(A[i] +","+ A[j]);
                count++;
                i++;
                j--;
            }
        }
        return count;
    }
    public static void main(String []args){
        int arr[] ={1,2,3,4,5};
        System.out.println(solve(arr,5));
    }
}
