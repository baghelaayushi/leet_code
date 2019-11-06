import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KangarooSubstrings {
    public static void main(String args[]){
        String s = "C:A,B,C";
        String a[] = s.split(":");
        HashMap<String, List<String>> hm = new HashMap<>();
        String key = a[0];
        String values[] = a[1].split(",");
        List<String> values_1 = new ArrayList<>();
        for(String b:values)
            values_1.add(b);
        hm.put(key,values_1);

    }
}
