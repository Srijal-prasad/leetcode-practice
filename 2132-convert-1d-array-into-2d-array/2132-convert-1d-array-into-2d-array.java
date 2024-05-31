class Solution {
    public int[][] construct2DArray(int[] arr, int m, int n) {
        int ans[][]=new int[m][n];
        int num=arr.length;
        if(num!=m*n)
          return new int[0][0];
          int k=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
            ans[i][j]=arr[k++]; 
            }
        }
        return ans;
    }
}
