public class TennisLogs {
    public static String solve(int A, int[] B) {
        char p1 = 'p';
        char p2 = 'q';
        char x = 'r';
        for(int i:B){
            if(i==1){
                if(p1 == 'p'){
                    char temp = p2;
                    p2 = x;
                    x = temp;
                }
                else if(p2 == 'p'){
                    char temp = p1;
                    p1 = x;
                    x = temp;
                }
                else
                    return "No";
            }
            if(i==2){
                if(p1 == 'q'){
                    char temp = p2;
                    p2 = x;
                    x = temp;
                }
                else if(p2 == 'q'){
                    char temp = p1;
                    p1 = x;
                    x = temp;
                }
                else
                    return "No";
            }
            if(i==3){
                if(p1 == 'r'){
                    char temp = p2;
                    p2 = x;
                    x = temp;
                }
                else if(p2 == 'r'){
                    char temp = p1;
                    p1 = x;
                    x = temp;
                }
                else
                    return "No";
            }
        }
        return "Yes";
    }
    public static void main(String[] args){
        int B[] = {3,1,1};
        System.out.println(solve(B.length,B));
    }
}
