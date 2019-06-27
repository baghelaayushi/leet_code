public class FindNExtNonZeroInteger {
    public static String solve(int A) {
        int temp = A+1;
        String output = "";

        while(temp > 0){
            if(temp% 10 == 0){
                output = output + Integer.toString(1);

            }
            else{
                output = output + Integer.toString(temp%10);
            }
            temp = temp/10;

            System.out.println(temp);
        }

        String output_final ="";
        int length = output.length();
        for(int i = length -1; i>=0;i--)
            output_final = output_final + output.charAt(i);


        return output_final;

    }
    public static void main(String args[]){
        String s = solve(99);
        System.out.println(s);
    }
}
