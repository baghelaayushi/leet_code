public class hcf {
    public static int gcd(int x, int y){
        if( x==0)
            return y;
        if(y==0)
            return x;
        if( x==y){
            return x;
        }
        if(x>y){
            return gcd(x%y,y);
        }
        return gcd(x,y%x);
    }
    public static int getDiff(int A) {
        double max=0.00000000;
        int difference = 1;
        for(int i = 1; i<=A/2;i++){
            int x = i;
            int y = A-i;
            int hcf = gcd(x,y);
            System.out.println(x+","+y+","+hcf);
            if(hcf==1){
                if((float)x/y > max){
                    max = x/y;
                    difference = y-x;
                }

            }
            System.out.println(max);

        }
        return difference;
    }
    public static void main(String args[]){
        //int x = getDiff(123);
        //System.out.print(x);
        System.out.println(gcd(6,9));
    }
}
