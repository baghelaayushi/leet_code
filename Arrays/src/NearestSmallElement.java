import java.util.Stack;

public class NearestSmallElement {
    public int[] prevSmaller(int[] A) {
        int [] output = new int[A.length];
        Stack<Integer> st = new Stack<>();
        output[0] = -1;
        st.push(A[0]);
        for(int i=1;i<A.length;i++){
            if(A[i]>st.peek())
                output[i] = st.peek();
            else {
                while(!st.empty() && st.peek()>=A[i])
                    st.pop();

                if(st.empty())
                    output[i] = -1;
                else
                    output[i] = st.peek();
            }
            st.push(A[i]);
        }

        return output;
    }
    public static void main(String args[]){
        int  []A = {39, 27, 11, 4, 24, 32, 32, 1};
        NearestSmallElement ob = new NearestSmallElement();
        int [] x = ob.prevSmaller(A);
        for(int i:x)
            System.out.println(i);
    }
}
