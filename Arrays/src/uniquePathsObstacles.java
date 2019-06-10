public class uniquePathsObstacles {
    public static void main(String[] args){
        int length = 3;
        int height = 7;
        if(length == 0 || height==0)
            System.out.println(1);
        else {
            int[][] nums = new int[length][height];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < height; j++) {
                    if (i > 0 && j > 0)
                        nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
                    else if (i == 0 && j == 0)
                        nums[i][j] = -1;
                    else if (i == 0 && j > 0)
                        nums[i][j] = nums[i][j - 1];
                    else if (j == 0 && i > 0)
                        nums[i][j] = nums[i - 1][j];
                }
            }
            System.out.println(-nums[2][6]);
        }


    }
}

