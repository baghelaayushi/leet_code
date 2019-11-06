import java.util.Stack;

public class RedundantBraces {
    public int braces(String A) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        for(int i = 0;i<A.length();i++){
            count =0;
            if(A.charAt(i)==')'){
                while(st.peek()!='(') {
                    st.pop();
                    count++;
                }
                if(count<=1)
                    return 1;
                st.pop();
            }
            else
                st.push(A.charAt(i));
        }
        return 0;
    }
    public static void main(String args[]){
        String S = "(a)";
        RedundantBraces ob = new RedundantBraces();
        System.out.println(ob.braces(S));
    }
}
