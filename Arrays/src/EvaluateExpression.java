import java.util.Stack;

public class EvaluateExpression {
    public int evalRPN(String[] A) {
        Stack<Integer> str = new Stack<>();
        int num1 =0;
        int num2 = 0;
        for(String temp:A){
            switch (temp){
                case "+":
                    if(!str.empty())
                        num1 = str.pop();
                    if(!str.empty())
                        num2 = str.pop();
                    str.push(num1+num2);
                    break;
                case "-":
                    if(!str.empty())
                        num1 = str.pop();
                    if(!str.empty())
                        num2 = str.pop();
                    str.push(num2-num1);
                    break;
                case "*":
                    if(!str.empty())
                        num1 = str.pop();
                    if(!str.empty())
                        num2 = str.pop();
                    str.push(num1*num2);
                    break;
                case "/":
                    if(!str.empty())
                        num1 = str.pop();
                    if(!str.empty())
                        num2 = str.pop();
                    str.push(num2/num1);
                    break;
                default:
                    str.push(Integer.parseInt(temp));
                    break;
            }
        }
        if(!str.empty())
            return str.pop();

        return -1;
    }
    public static void main(String args[]){
        String A[] = {"4", "13", "5", "/", "+"};
        EvaluateExpression ob = new EvaluateExpression();
        int x = ob.evalRPN(A);
        System.out.println(x);

    }
}
