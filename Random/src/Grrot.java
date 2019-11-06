import java.util.Arrays;

public class Grrot {
    public static int getSum(int A, int B, int[] C) {
        String s = "abcdef";

        for(int i=0;i<s.length();i++){
            int x = s.charAt(i)-97;
            System.out.println(x);
        }
        Arrays.sort(C);
        int min = C[0];
        int max = C[C.length-1];
        int count[]= new int[max-min+2];
        for(int i: C){
            count[i]++;
        }
        int m = 1000000007;
        int sum = 0;
        for(int x=0;x<count.length; x++){
            if(count[x]==B){
                sum+= x%m;
            }
        }
        if(sum==0)
            return -1;
        else
            return sum;
    }
    public static void main(String args[]){
        int arr[] =  {1,2,2,3,3};
        System.out.println(getSum(5,2,arr));
    }
}
