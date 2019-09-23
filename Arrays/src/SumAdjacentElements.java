public class SumAdjacentElements {
    public int solve(int[] A) {
        int count =0;
        for(int i:A)
            if(i%2==0)
                count++;

        return Integer.min(count,A.length-count);
    }
    public static void main(String args[]){
        SumAdjacentElements ob  = new SumAdjacentElements();
        int A[] = {5, 17, 100, 11};
        System.out.println(ob.solve(A));
    }
}
