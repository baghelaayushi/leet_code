import java.util.HashMap;

public class ChangeString {
    private static void change(String s){
        HashMap<String,String> hm = new HashMap<>();
        hm.put("a","y");
        hm.put("b","h");
        hm.put("c","e");
        hm.put("d","s");
        hm.put("e","o");
        hm.put("f","c");
        hm.put("g","v");
        hm.put("h","x");
        hm.put("i","d");
        hm.put("j","u");
        hm.put("k","i");
        hm.put("l","g");
        hm.put("m","l");
        hm.put("n","b");
        hm.put("o","k");
        hm.put("p","r");
        hm.put("q","z");
        hm.put("r","t");
        hm.put("s","n");
        hm.put("t","w");
        hm.put("u","j");
        hm.put("v","p");
        hm.put("w","f");
        hm.put("x","m");
        hm.put("y","a");
        hm.put("z","q");

        String output = "";

        for(int i=0;i<s.length();i++){
            String temp = "";
            if(s.charAt(i) != ' ') {
                 temp = output + hm.get(Character.toString(s.charAt(i)));
                output = temp;
            }
            else{
                temp = output + " ";
                output = temp;

            }

        }

        System.out.println(output);
    }
    public static void main(String[] args) {
        String s = "tc rbkso rbyr ejp mysljylc kd kxveddknmc re jsicpdrysi de kr kd eoya kw aej icfkici re zjkr";
        change(s);
    }
}
