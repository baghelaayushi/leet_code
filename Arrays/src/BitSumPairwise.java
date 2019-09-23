public class BitSumPairwise {
    public int cntBits(int[] A) {
        int sol = 0;
        int zero_count =0;
        for(int j=0;j<32;j++){
            int first_count =0;
            int second_count =0;
            for(int i:A){
                int x = (i>>j) & 1;
                if(x == 1)
                    first_count++;
                else
                    second_count++;

                if(first_count!=0 && second_count!=0)
                    sol+= first_count*second_count;
            }
            if(first_count==0 || second_count==0)
                zero_count++;
        }
        System.out.println(zero_count);
        if(zero_count == 33)
            return 0;
        return sol;
    }
    public static void main(String args[]){
        int A[] ={1,3,5};
        BitSumPairwise ob  = new BitSumPairwise();
        System.out.println(ob.cntBits(A));
    }
}
