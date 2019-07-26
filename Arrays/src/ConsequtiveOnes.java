public class ConsequtiveOnes {
    public static int solve(String A){
        int front[] = new int[A.length()+2];
        int back[] = new int[A.length()+2];
        front[0] = 0;
        back[back.length-1] = 0;
        int countFront = 0;
        int countBack = 0;
        int countOnes =0;
        int j = A.length()-1;
        for(int i=0;i<A.length();i++){
             if(A.charAt(i) == '1'){
                 countFront++;
                 countOnes++;
                 front[i+1] = countFront;
             }
             else
                 countFront = 0;

             if(A.charAt(j) == '1'){
                 countBack++;
                 back[j+1] = countBack;
             }
             else
                 countBack =0;

             j--;
        }

        int max = back[1];
        for(int i=1;i<front.length-1;i++){
           if(front[i] == 0){
               int temp = front[i-1]+back[i+1];
               if(temp < countOnes){
                   temp++;
                   if(temp > max)
                       max = temp;}
               else{
                   if(front[i-1]>= back[i+1])
                       temp = front[i-1];
                   else
                       temp = back[i+1];

                   if(front[i-1] ==0 || back[i+1]==0)
                       max= temp;
                   else
                       max = front[i-1]+back[i+1];
               }
           }

        }


     return max;
    }
    public static void main(String args[]){
        String A = "1110";
        System.out.println(solve(A));

    }
}
