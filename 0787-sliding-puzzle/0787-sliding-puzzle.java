class Solution {
    int r=2;
    int c=3;
    int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
    int min=Integer.MAX_VALUE;
    public int slidingPuzzle(int[][] board) {
        int x=0;
        int y=0;
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]==0){
                    x=i;
                    y=j;
                    break;
                }
            }
        }
        recur(board,x,y,0,new int[]{-1,-1});

        return (min==Integer.MAX_VALUE)?-1:min;

    }
    public void recur(int[][] board, int x, int y, int count, int[] previous) {
        if (count >= 20) return; 

        if (equal(board)) {
            min = Math.min(min, count);
            return;
        }

        for (int[] dir : directions) {
            int dx = dir[0] + x;
            int dy = dir[1] + y;

            if (dx >= 0 && dx < 2 && dy >= 0 && dy < 3 && (previous == null || !(dx == previous[0] && dy == previous[1]))) {
                int temp = board[dx][dy];
                board[dx][dy] = board[x][y];
                board[x][y] = temp;

                recur(board, dx, dy, count + 1, new int[]{x, y});

            
                temp = board[dx][dy];
                board[dx][dy] = board[x][y];
                board[x][y] = temp;
            }
        }
    }


    public boolean equal(int[][] board){
        int puzzleValue = 1;

        for(int row=0; row<2; row++){
            for(int col=0; col<3; col++){
                if(row == 1 && col == 2) continue; 
                if(board[row][col] != puzzleValue++) return false;
            }
        }
        return true;
    }
}