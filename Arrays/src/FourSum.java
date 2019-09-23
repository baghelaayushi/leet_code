import java.util.*;

public class FourSum {
    public static int[][] fourSum(int[] A, int B) {
        List<List<Integer>> lst = new ArrayList<>();
        HashMap<Integer, List<List<Integer>>> hm=new HashMap<Integer,List<List<Integer>>>();
        HashMap<Integer, List<List<Integer>>> hm1=new HashMap<Integer,List<List<Integer>>>();

        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                if(i !=j){
                    int sum = B-(A[i]+A[j]);
                    if(hm.containsKey(sum)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        hm.get(sum).add(temp);
                    }
                    else {
                        List<List<Integer>> temp = new ArrayList<>();
                        List<Integer> temp1 = new ArrayList<>();
                        temp1.add(i);
                        temp1.add(j);
                        temp.add(temp1);
                        hm.put(sum,temp);
                    }
                }
            }
        }
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                if(i !=j){
                    int sum = A[i]+A[j];
                    if(hm.containsKey(sum)) {
                        for(List<Integer> l1:hm.get(sum)){
                            if(j< l1.get(0)) {
                                List<Integer> temp = new ArrayList<>();
                                temp.add(A[i]);
                                temp.add(A[j]);
                                temp.add(A[l1.get(0)]);
                                temp.add(A[l1.get(1)]);
                                lst.add(temp);
                            }

                        }

                    }

                }
            }
        }


        int output[][] =new int[lst.size()][];

        for(int m =0; m<lst.size();m++){
            output[m] = new int[lst.get(m).size()];
            for(int n=0; n<lst.get(m).size();n++){
                output[m][n] = lst.get(m).get(n);
            }
            Arrays.sort(output[m]);
        }
        return output;
    }
    public static void main(String args[]){
        int A[] = { 9, -8, -10, -7, 7, -8, 2, -7, 4, 7, 0, -3, -4, -5, -1, -4, 5, 8, 1, 9, -2, 5, 10, -5, -7, -1, -6, 4, 1, -5, 3, 8, -4, -10, -9, -3, 10, 0, 7, 9, -8, 10, -9, 7, 8, 0, 6, -6, -7, 6, -4, 2, 0, 10, 1, -2, 5, -2};
        int x[][] = fourSum(A,0);
        for(int i[]:x){
            if(i[0] == -10 && i[1] == -10) {
                for (int j : i) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        }
    }
}
