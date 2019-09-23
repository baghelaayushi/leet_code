public class BitManipulationSingleNumber {
    public int singleNumber(final int[] A) {
        int x = 0;
        for(int i:A)
            x = i ^ x;

        return x;
    }
    public static void main(String args[]){
        int []A ={1,2,2,3,1};
        BitManipulationSingleNumber ob = new BitManipulationSingleNumber();
        System.out.println(ob.singleNumber(A));
    }
}
