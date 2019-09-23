import java.util.Collections;
import java.util.PriorityQueue;

public class StackCubes {
    public static int solve(int A) {
     int count =0;
     int p = 1;
     int n = A-p;
     while(p<=n){
         if(n%p == 0)
             count++;
         p++;
         n = A-p;
     }
     return count;
    }
    public static void main(String args[]){
        System.out.println(solve(6));
        int a[] = {2,1,3,4,5};
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for(int i:a)
            pQueue.add(i);

        System.out.println(pQueue.peek());


    }

}
