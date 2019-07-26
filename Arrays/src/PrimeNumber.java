public class PrimeNumber {
    static int isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return 1;

        // Check from 2 to n-1
        for (int i = 2; i*i <= n; i++)
            if (n % i == 0)
                return 0;

        return 1;
    }

    /* Driver program  */
    public static void main(String[] args)
    {
        System.out.println(isPrime(5));

    }
}
