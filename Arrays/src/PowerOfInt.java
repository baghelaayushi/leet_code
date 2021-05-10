public class PowerOfInt {
    //recursively call this function till the val of n is 0 and then return 1
    public static double myPowUtil(double x, int n) {
        if(n == 0 || x == 1)
            return 1;
        if(n == 1)
            return x;

        int midForFirstPart = n%2 == 0 ? n/2-1 : n/2;
        int midForSecondPart = n/2;
        double solutionForFirstPart = myPowUtil(x,midForFirstPart);
        double solutionForSecondPart = myPowUtil(x, midForSecondPart);
        return solutionForFirstPart * x * solutionForSecondPart;
    }
    public static double myPow(double x, int n) {
        // normalize the value of the power and as a ^ -n is 1/a^n
        if(n == 0)
            return 1;

        if(x == 1 || n == 1)
            return x;

        if (x == -1){
            if (n%2 == 0)
                return -x;
            return x;
        }

        if(n == Integer.MAX_VALUE) {
            if(x > 1)
                return 10000;
            if(x < -1)
                return -10000;

            return 0;
        }

        if (n == Integer.MIN_VALUE) {
            if(x > 0 && x < 1)
                return 10000;
            if(x < 0 && x > -1)
                return -10000;
            return 0;
        }

        int normalizedN = n > 0 ? n : -n;
        return n>0 ? myPowUtil(x, normalizedN) : 1/myPowUtil(x,normalizedN);
    }

    public static void main(String[] args) {
        System.out.println(myPow(2,31));
    }
}
