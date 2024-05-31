class Solution {
    public int[][] construct2DArray(int[] arr, int m, int n) {
        int ans[][]=new int[m][n];
        int num=arr.length;
        if(num!=m*n)
          return new int[0][0];
        for(int i=0;i<num;i++)
        {
            ans[i / n][i % n] = arr[i];
        }
        return ans;
    }
}
