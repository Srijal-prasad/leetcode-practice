class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
      List<Integer> ans=new ArrayList<>();
      int m=arr.length;
      int n=arr[0].length;
      int top=0,left=0;
      int bottom=m-1,right=n-1;

      if (arr == null || m == 0) 
       return ans;

    while (top <= bottom && left <= right) 
    {
      for(int i=left;i<=right;i++)
      {
            ans.add(arr[top][i]);
      }
         top++;
        for(int i=top;i<=bottom;i++)
        {
            ans.add(arr[i][right]);
        }
           right--;

     if(top<=bottom){
        for(int i=right;i>=left;i--)
        {
            ans.add(arr[bottom][i]);
        }
        bottom--;
     }

     if(left<=right){
        for(int i=bottom;i>=top;i--)
        {
            ans.add(arr[i][left]);
        }
        left++; 
     }
    }
    return ans;
    }
}