import java.security.cert.X509Certificate;
import java.util.ArrayList;

public class CaptureRegions {
    static boolean visited[][];
    public static ArrayList<ArrayList<Character>> solveUtil(ArrayList<ArrayList<Character>> a,int i, int j){
        visited[i][j] = true;
        ArrayList<Character> temp = a.get(i);
        temp.set(j,'T');
        a.set(i,temp);

        if(i-1!=-1 && a.get(i-1).get(j)=='O'&&!visited[i-1][j])
            a = solveUtil(a,i-1,j);

        if(j-1!=-1 && a.get(i).get(j-1)=='O'&&!visited[i][j-1])
            a = solveUtil(a,i,j-1);

        if(i+1!=a.size() && a.get(i+1).get(j)=='O'&&!visited[i+1][j])
            a = solveUtil(a,i+1,j);

        if(j+1!=a.get(i).size() && a.get(i).get(j+1)=='O'&&!visited[i][j+1])
            a = solveUtil(a,i,j+1);

        return a;
    }
    public static void solve(ArrayList<ArrayList<Character>> a) {
        visited = new boolean[a.size()][a.get(0).size()];
        int length= a.size();
        int breadth = a.get(0).size();

        for(int i=0;i<a.get(0).size();i++)
            if(a.get(0).get(i)=='O')
                a = solveUtil(a,0,i);

        for(int i=0;i<a.get(0).size();i++)
            if(a.get(i).get(0)=='O')
                a = solveUtil(a,i,0);

        for(int i=0;i<a.get(0).size();i++)
            if(a.get(3).get(i)=='O')
                a = solveUtil(a,length-1,i);

        for(int i=0;i<a.get(0).size();i++)
            if(a.get(i).get(3)=='O')
                a = solveUtil(a,i,breadth-1);


        for(int i =0;i<a.size();i++)
            for(int j=0;j<a.get(0).size();j++)
                if(a.get(i).get(j)=='O'){
                    ArrayList<Character> temp = a.get(i);
                    temp.set(j,'X');
                    a.set(i,temp);
                }

        for(int i =0;i<a.size();i++)
            for(int j=0;j<a.get(0).size();j++)
                if(a.get(i).get(j)=='T'){
                    ArrayList<Character> temp = a.get(i);
                    temp.set(j,'O');
                    a.set(i,temp);
                }

    }
    public static void main(String args[]){
        ArrayList<ArrayList<Character>> a = new ArrayList<>(4);
        ArrayList<Character> c = new ArrayList<>();
        c.add('X');
        c.add('X');
        c.add('X');
        c.add('X');
        a.add(c);
        c = new ArrayList<>();
        c.add('X');
        c.add('O');
        c.add('O');
        c.add('X');

        a.add(c);
        c = new ArrayList<>();
        c.add('X');
        c.add('X');
        c.add('O');
        c.add('X');

        a.add(c);
        c = new ArrayList<>();
        c.add('X');
        c.add('O');
        c.add('X');
        c.add('X');

        a.add(c);

        solve(a);
    }
}
