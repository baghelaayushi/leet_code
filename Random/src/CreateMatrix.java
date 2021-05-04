import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateMatrix {
    public static void create(String s, int N, String searched) {
        int matrix[][] = new int[N][N];
        HashMap<Integer, HashSet<String>> hm = new HashMap<>();
        HashMap<String, Integer> reverseMap = new HashMap<>();
        String str[] = s.split(",");
        int count = 1;
        for (String u : str) {
            String topLeft = u.split(" ")[0];
            String bottomRight = u.split(" ")[1];

            int leftX = Integer.parseInt(topLeft.split("")[0]);
            char leftXChar = topLeft.split("")[1].toCharArray()[0];

            int rightX = Integer.parseInt(bottomRight.split("")[0]);
            char rightXChar = bottomRight.split("")[1].toCharArray()[0];
            System.out.println("Here");


            for (int i = leftX; i <= rightX; i++) {
                for (int j = leftXChar; j <= rightXChar; j++) {
                    if(hm.containsKey(count)){
                        HashSet<String> temp = hm.get(count);
                        temp.add(String.valueOf(i)+(char)j);
                        hm.replace(count,temp);
                    }
                    else {
                        HashSet<String> temp = new HashSet<>();
                        temp.add(String.valueOf(i)+(char)j);
                        hm.put(count,temp);
                    }
                    reverseMap.put(String.valueOf(i)+(char)j,count);

                }
            }
            count++;
        }
        int output[] = new int[2];
        Set<Integer> partiallyDiscovered = new HashSet<>();

        String searchArray[] = searched.split(" ");
        for(String strn: searchArray){
            if(reverseMap.containsKey(strn)) {
                int value = reverseMap.get(strn);
                HashSet<String> temp = hm.get(value);
                temp.remove(strn);
                hm.put(value, temp);
                partiallyDiscovered.add(value);
            }

        }
        int fullDiscovered = 0;
        for(Map.Entry<Integer,HashSet<String>> m: hm.entrySet()){
            if(m.getValue().isEmpty())
                fullDiscovered++;
        }

        System.out.println(fullDiscovered);
        System.out.println(partiallyDiscovered.size() - fullDiscovered);

      for(Map.Entry<String,Integer> m: reverseMap.entrySet()){
          System.out.print(m.getKey());
          System.out.print("->");
          System.out.print(m.getValue());
          System.out.println();
      }

        for(Map.Entry<Integer,HashSet<String>> m: hm.entrySet()){
            System.out.print(m.getKey());
            System.out.print("->");
            System.out.print(m.getValue());
            System.out.println();
        }

    }

    public static void main(String[] args) {
        create("1B 2C,2D 4D",4,"2B 2D 3D 4D 4A");
    }
}
