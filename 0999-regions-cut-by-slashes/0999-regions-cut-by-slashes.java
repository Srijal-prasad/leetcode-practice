class Solution {
    public int regionsBySlashes(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();

        int nRows = 3*rows;
        int nCols = 3*cols;

        int grid2[][] = new int[nRows][nCols];
        for (int[] r : grid2) {
            Arrays.fill(r, 0);
        }  
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                char c = grid[i].charAt(j);
                int r2= 3*i, c2= 3*j;

                if(c=='/'){
                   grid2[r2][c2+2]=1;
                   grid2[r2+1][c2+1]=1;
                   grid2[r2+2][c2]=1;
                }
                else if(c=='\\'){
                   grid2[r2][c2]=1;
                   grid2[r2+1][c2+1]=1;
                   grid2[r2+2][c2+2]=1;
                }
            }
        }
        int ans=0;
        for(int i=0;i<nRows;i++){
            for(int j=0;j<nCols;j++){
                if(grid2[i][j]==0){
                    ans++;
                    makeAdjacentOne(grid2,i+1,j);
                    makeAdjacentOne(grid2,i,j+1);
                    makeAdjacentOne(grid2,i-1,j);
                    makeAdjacentOne(grid2,i,j-1);
                }
            }
        }
        return ans;
    }

    public void makeAdjacentOne(int[][] grid2, int i, int j){
        if(i<0 || j<0 || i>=grid2.length || j>=grid2[0].length) return ;

        if(grid2[i][j] !=1){
            grid2[i][j]=1;
            makeAdjacentOne(grid2,i+1,j);
            makeAdjacentOne(grid2,i,j+1);
            makeAdjacentOne(grid2,i-1,j);
            makeAdjacentOne(grid2,i,j-1);
        }
    }
}