import java.math.BigInteger;

public class RemoveKDigits {
    // this method calculates the minimum value
    // by removing digits one at a time
    static String calcu_min(String number){
        String temp = number;
        BigInteger min = new BigInteger(number);
        int length = temp.length();
        for(int i=0; i< length; i++){
            number = number.substring(0, i) + number.substring(i + 1);
            BigInteger temp1 = new BigInteger(number);
            if(min.compareTo(temp1) == 1)
                min = temp1;
            number = temp;
        }
     return String.valueOf(min);
    }
    // this method removes local maximas starting from right
    static String calcu_min(String number, int k){
        int i =0;
        while(i<number.length()){

        }
        return number;

    }

    public static void main(String []args){
        String num = "1432219";
        int k = 3;
        if (num.length() == k)
            System.out.println("null");
        else {
            for (int j = 0; j < num.length(); j++) {
                    if (0 == (Character.getNumericValue(num.charAt(j)))){
                            num = num.substring(j + 1);
                    }
                }
            for (int i = 0; i<k;i++){
                BigInteger temp = new BigInteger(num);
                if(temp.equals(new BigInteger("0")))
                    break;
                else
                {
                    num = calcu_min(num);
                }

            }
        }
        System.out.println(num);
    }
}
