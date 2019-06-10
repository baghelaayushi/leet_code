import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindReccuringElement {
    static List<Integer> find(int[] arr){
        List<Integer> output = new ArrayList<>();
        if(arr.length>0){
            int max = Arrays.stream(arr).max().getAsInt();
            int min = Arrays.stream(arr).min().getAsInt();
            int range;
            if(max==min){
                range = max;
            }
            else
                range = max - min + 1;
            //System.out.println(range);
            int[] count = new int[range + 1];
            //System.out.println(count.length);
            for (int i = 0; i < arr.length; i++)
            {
                count[arr[i]-min]++;
                //System.out.println(count[arr[i]]);
            }
            for (int i = 0; i < count.length; i++)
            {
                System.out.println(count[i]);
                //System.out.println(count[arr[i]]);
            }
            for(int i = 0;i< count.length;i++)
                if(count[i] == 2)
                    output.add(i+min);
        }
        return output;
    }
    public static void main(String[] args){
        int[] nums = {5, 4, 6, 7, 9, 3, 10, 9, 5, 6};
        List<Integer> output = find(nums);
        System.out.println(output);


    }
}
