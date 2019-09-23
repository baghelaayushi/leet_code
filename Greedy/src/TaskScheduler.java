import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskScheduler {

    public static int solve(String A, int B) {
        int count_array[] = new int[26];
        for(int i=0;i<A.length();i++)
            count_array[A.charAt(i)-65]++;

        Arrays.sort(count_array);
        int max_val = count_array[count_array.length-1];
        int max_count =0;
        System.out.println(max_val);
        System.out.println(max_count);
        for(int i = count_array.length-1;i>=0;i--){
            if(count_array[i] == max_val)
                max_count++;
            else
                break;
        }
        System.out.println(max_count);

        /*List<Integer> lst = new ArrayList<>();
        for(int i =count_array.length-1;i>=0;i--){
            if(count_array[i] == 0)
                break;
            lst.add(count_array[i]);
        }*/

        return Math.max(((max_val-1)*(B+1)+max_count),A.length());
    }
    public static void main(String args[]){
        System.out.println(solve("AECBADCBDE",2));
    }
}
