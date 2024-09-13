class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
       int n=arr.length;
       int prefix[]=new int[n]; 
       prefix[0]=arr[0];
       int q=queries.length;
       int ans[]=new int[q];
       for(int i=1;i<n;i++)
       {
           prefix[i]=prefix[i-1]^arr[i];
       }
       for(int i=0;i<q;i++)
       {
           int left=queries[i][0];
           int right=queries[i][1];
           if(left==0)
            ans[i]=prefix[right];
           else
            ans[i]=prefix[left-1]^prefix[right];
       }
       return ans;
    }
}