class Solution {
    public int heightChecker(int[] heights) {
        int arr[]=heights.clone();
        Arrays.sort(arr);
        int n=heights.length,ans=0;
        for(int i=0;i<n;i++)
        {
          if(heights[i]!=arr[i])
            ans++;
        } 
        return ans;
    }
}