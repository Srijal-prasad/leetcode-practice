class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;   
        int n = box[0].length; 

        for (int i = 0; i < m; i++) {
            int emptyIndex = n - 1; 
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    emptyIndex = j - 1;
                } else if (box[i][j] == '#') {
                    box[i][j] = '.';
                    box[i][emptyIndex] = '#';
                    emptyIndex--;
                }
            }
        }
        char[][] rotatedBox = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedBox[j][m - i - 1] = box[i][j];
            }
        }

        return rotatedBox;

    }
}