import java.util.Queue;
import java.util.Stack;

public class RemoveInvalidParantheses {
    public boolean isValid(String s){
        Stack<Character> expected = new Stack<>();

        for (char c : s.toCharArray()) {
            Character e = null;

            switch(c) {
                case '(':
                    e = ')';
                    break;
                case '{':
                    e = '}';
                    break;
                case '[':
                    e = ']';
                    break;
            }

            if (e != null) {
                expected.push(e);
            } else if(expected.size() == 0 || expected.pop() != c) {
                return false;
            }
        }

        return expected.size() == 0;

    }
    public Queue<String> smallest(Queue<String> queue){
        if(!queue.isEmpty()){
            Queue<String> temp = queue;
        }
        return queue;
    }
}
