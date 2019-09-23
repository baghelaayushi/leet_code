public class BinaryStrings {
    public static int solve(String A, int B) {
        int count = 0;
        int N = A.length();
        StringBuilder a = new StringBuilder(A);
        for(int i =0;i<= N-B;i++){
            if(a.charAt(i) == '0'){
                count++;
                for(int j=i;j<i+B;j++){
                    if(a.charAt(j) == '0')
                        a.setCharAt(j,'1');
                    else
                        a.setCharAt(j,'0');
                }
            }
        }
        for(int i = N-B; i< N;i++)
            if(a.charAt(i)== '0')
                return -1;

        return count;
    }
    public static void main(String args[]){
        System.out.println(solve("00010110",3));
    }
}
