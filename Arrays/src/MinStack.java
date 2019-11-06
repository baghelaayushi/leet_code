import java.util.Stack;

public class MinStack {
    Stack<Integer> minStack = new Stack<>();
    int min = Integer.MAX_VALUE;
    public void push(int x) {
        if(x <= min){
            if(min == Integer.MAX_VALUE) {
                minStack.push(x);
                minStack.push(x);
            }
            else {
                minStack.push(min);
                minStack.push(x);
            }
            min =x;
        }
        else {
            minStack.push(x);
        }

    }

    public void pop() {
        if(minStack.empty()){
            return;
        }

        if(minStack.peek() == min){
            minStack.pop();
            min = minStack.pop();
        }
        else
            minStack.pop();

    }
    public int top() {
        if(minStack.empty()){
            return -1;
        }
        int x;
        if(minStack.peek() == min){
            x = minStack.pop();
            min = minStack.pop();
        }
        else
            x = minStack.pop();

        return x;

    }

    public int getMin() {
        if(min == Integer.MAX_VALUE && minStack.empty()){
            return -1;
        }
        return min;
    }
    public static void main(String args[]){
        MinStack ob = new MinStack();
        ob.pop();
        ob.push(644643544);
        System.out.println(ob.getMin());
        System.out.println(ob.min);
        System.out.println(ob.top());
        System.out.println(ob.min);
        System.out.println(ob.top());
        System.out.println(ob.min);
        System.out.println(ob.top());


    }
}
