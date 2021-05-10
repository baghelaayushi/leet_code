public class MaxNumberOfVowels {
    public static int [] increaseVal(int[] arr, char vowel) {
        switch (vowel) {
            case 'a' :
                arr[0]++;
                break;
            case 'e' :
                arr[1]++;
                break;
            case 'i' :
                arr[2]++;
                break;
            case 'o' :
                arr[3]++;
                break;
            case 'u' :
                arr[4]++;
                break;
        }
        return arr;
    }

    public static int [] decreaseVal(int[] arr, char vowel) {
        switch (vowel) {
            case 'a' :
                arr[0]--;
                break;
            case 'e' :
                arr[1]--;
                break;
            case 'i' :
                arr[2]--;
                break;
            case 'o' :
                arr[3]--;
                break;
            case 'u' :
                arr[4]--;
                break;
        }
        return arr;
    }

    public static int countArr(int arr[]){
        int count = 0;
        for(int i: arr){
            count+=i;
        }

        return count;
    }

    public static void printArr(int[] arr){
        for(int i: arr)
            System.out.print(i);
    }
    public static int maxVowels(String s, int k) {
        int lengthOfString = s.length();
        // index of this array determines the count of a vowel
        //TODO modify this to use just one variabe instead of the array
        // can switch to using a single variable
        int arr[] = new int[]{0,0,0,0,0};
        // intially counting the vowel in first k substring
        for (int i = 0; i < k ; i++) {
            increaseVal(arr, s.charAt(i));
        }

        printArr(arr);
        System.out.println();

        int max = countArr(arr);
        int i=1;
        int j = i+k-1;
        // finding vowels in subsequent substring
        // removing the vowel count from array for i-1
        // adding the vowel count if char at j is a vowel
        for(i = 1; i <= lengthOfString-k ; i++,j=i+k-1) {
            System.out.println(s.charAt(i-1));
            decreaseVal(arr,s.charAt(i-1));
            printArr(arr);
            System.out.println();
            increaseVal(arr, s.charAt(j));
            max = Integer.max(countArr(arr), max);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxVowels("tryhard", 3));
    }
}

