public class PascalTriangle {
    public int[][] solve(int A) {
        int output[][] = new int[A][];
        int first[] = {1};
        int second[];
        output[0] = first;
        if(A==0)
            return output;

        int count =1;
        while(count<A){
            second = new int[first.length + 1];
            second[0] = 1;
            second[second.length - 1] = 1;
            for(int i =1;i<second.length-1;i++)
                second[i]=first[i-1]+first[i];
            output[count] = second;
            first = second;
            count++;
        }
        return output;
    }
    public int[] getRow(int A) {
        int first[] = {1};
        int second[];
        if(A==0)
            return first;
        int count = 1;
        while(count<= A) {
            second = new int[first.length + 1];
            second[0] = 1;
            second[second.length - 1] = 1;
            for(int i =1;i<second.length-1;i++)
                second[i]=first[i-1]+first[i];

            first = second;
            count++;
        }

        return first;
    }
    public static void main(String args[]){
        PascalTriangle ob  = new PascalTriangle();
        int A[] = ob.getRow(6);
        for(int i:A)
            System.out.println(i);
        int x[][] = ob.solve(5);
        for(int i[]:x){
            for(int m:i)
                System.out.print(m + "  ");
            System.out.println();
        }
    }
}
