import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LongestValidParetheses {
    public int longestValidParentheses(String A) {
        Stack<Integer> stack = new Stack<>();
        boolean toggle = false;
        stack.push(-1);
        int count = 0;
        for(int i=0;i<A.length();i++){
            switch (A.charAt(i)){
                case ')':
                    stack.pop();
                    if (stack.empty()) {
                        stack.push(i);
                    } else {
                        count = Math.max(count, i - stack.peek());
                    }
                    break;
                case '(':
                    stack.push(i);
                    break;
            }
        }
        return count;
    }
    public static void main(String args[]){
        LongestValidParetheses ob = new LongestValidParetheses();
        System.out.println(ob.longestValidParentheses(")()))(())((())))))())()(((((())())((()())(())((((())))())((()()))(()(((()()(()((()()))(())()))((("));
    }
}
