class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char [][] grid = new char[m][n];

        for (int[] block :walls){
            grid[block[0]][block[1]]='w';

        }
         for (int[] block :guards){
            grid[block[0]][block[1]]='g';
            
        }

        for (int block[]:guards){
            int row = block[0];
            int col=block[1];

            for (int i=row+1;i<m;i++){
                if (grid[i][col]=='g'|| grid[i][col]=='w'){
                    break;
                }
                grid[i][col]='y';
            }

            for (int i=row-1;i>=0;i--){
                if (grid[i][col]=='g'|| grid[i][col]=='w'){
                    break;
                }
                grid[i][col]='y';
            }

            for (int i=col+1;i<n;i++){
                 if (grid[row][i]=='g'|| grid[row][i]=='w'){
                    break;
                }
                grid[row][i]='y';
            }

             for (int i=col-1;i>=0;i--){
                 if (grid[row][i]=='g'|| grid[row][i]=='w'){
                    break;
                }
                grid[row][i]='y';
            }
        }

        int result =0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]!='y'&&grid[i][j]!='g'&&grid[i][j]!='w'){
                    result++;
                }
            }
        }

        return result;
    }
}