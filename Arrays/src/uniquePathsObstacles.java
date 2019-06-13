public class uniquePathsObstacles {
    public static void main(String[] args){
        // the value 1 represents an obstacle
        int[][] obstacleGrid = {{0,0},{1,1},{0,0}};
        int length = obstacleGrid.length;
        int height = obstacleGrid[0].length;

        // checking if the start value is not one
        if(obstacleGrid[0][0] != 1) {
            if (length > 1 && height > 1) {
                for (int i = 0; i < length; i++) {
                    for (int j = 0; j < height; j++) {
                        if (obstacleGrid[i][j] != 1) {
                            if (i == 0 && j == 0)
                                obstacleGrid[i][j] = -1;
                            else if ((i == 0 || obstacleGrid[i - 1][j] == 1) && j>0)
                                obstacleGrid[i][j] = obstacleGrid[i][j - 1];
                            else if ((j == 0  || obstacleGrid[i][j - 1] == 1) && i > 0)
                                obstacleGrid[i][j] = obstacleGrid[i - 1][j];
                            else if (i > 0 && j > 0)
                                obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];

                        }

                    }

                }
                if(obstacleGrid[length - 1][height - 1] == 1)
                    System.out.println(0);
                else
                    System.out.println(-obstacleGrid[length - 1][height - 1]);
            } else if (length == 1 && height > 1) {
                for (int i = 0; i < height; i++) {
                    if (obstacleGrid[0][i] == 1) {
                        System.out.println(0);
                        break;
                    }
                }
                System.out.println(1);
            } else if (height == 1 && length > 1) {
                for (int i = 0; i < length; i++) {
                    if (obstacleGrid[i][0] == 1) {
                        System.out.println(0);
                        break;
                    }
                }
            } else if (height == 1 && length == 1) {
                if (obstacleGrid[0][0] == 1)
                    System.out.println(0);
                else
                    System.out.println(1);
            } else
                System.out.println(0);
        }
        else
            System.out.println(0);

    }
}

