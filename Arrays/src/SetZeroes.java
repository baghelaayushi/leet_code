import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetZeroes {
    public static void setZeroes(ArrayList<ArrayList<Integer>> a){
        int row[] = new int[a.size()];
        int column[] = new int[a.get(0).size()];
        for(int i = 0; i<a.size();i++){
            for(int j=0; j<a.get(0).size();j++){
                if(a.get(i).get(j)== 0){
                    row[i] = 1;
                    column[j]=1;
                }
            }
        }

        for(int i=0; i<a.size();i++)
            System.out.println(row[i]+","+column[i]);

        for(int i = 0; i<a.size();i++){
            for(int j=0; j<a.get(0).size();j++){
                if(row[i]== 1 || column[j]==1){
                    a.get(i).set(j,0);
                }
            }
        }
        System.out.println(a);

    }

    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> a = new ArrayList<>(3);
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(0);
        temp.add(0);
        temp.add(0);
        a.add(temp);

        temp = new ArrayList<>();
        temp.add(1);
        temp.add(0);
        temp.add(1);
        a.add(temp);

        temp = new ArrayList<>();
        temp.add(1);
        temp.add(1);
        temp.add(1);
        a.add(temp);

        System.out.println(a);
        setZeroes(a);

    }
}
