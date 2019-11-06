public class RainWater {
    public int trap(final int[] A) {
        int left[] = new int[A.length];
        int right[] = new int[A.length];
        left[0] =-1;
        right[right.length-1] = -1;
        int max = A[0];
        for(int i =1;i<A.length;i++){
            if(A[i]<max){
                left[i] = max;
            }
            else{
                left[i] = -1;
                max = A[i];
            }
        }
        max = A[A.length-1];
        for(int i =A.length -2;i>=0;i--){
            if(A[i]<max){
                right[i] = max;
            }
            else{
                right[i] = -1;
                max = A[i];
            }
        }
        int sum =0;
        for(int i =0;i<A.length;i++){
            if(left[i]!=-1 && right[i]!=-1)
                sum+= (Integer.min(left[i],right[i]) - A[i]);
        }
        return sum;
    }
}
