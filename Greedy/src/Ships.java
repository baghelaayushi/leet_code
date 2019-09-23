import java.util.Collections;
import java.util.PriorityQueue;

public class Ships {
    public static int[] solve(int A, int B, int[] C) {
        int max_sum =0, min_sum=0;
        PriorityQueue<Integer> min_heap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:C){
            min_heap.add(i);
            max_heap.add(i);
        }
        int x = A;
        while(x>0){
            min_sum += min_heap.peek();
            int temp = min_heap.poll()-1;
            if(temp !=0)
                min_heap.add(temp);
            x--;
        }

        x = A;
        while(x>0){
            max_sum+= max_heap.peek();
            int temp = max_heap.poll()-1;
            if(temp != 0)
                max_heap.add(temp);
            x--;
        }

        int output[] = {max_sum,min_sum};
        return output;
    }
    public static void main(String args[]){
        int c[] = {2,2,2};
        int arr[] = solve(4,3,c);
        System.out.println(arr[0] + "  " + arr[1]);
    }
}
