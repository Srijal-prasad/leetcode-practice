class Solution {
    public int candy(int[] rate) {
        int ans=0;
        int n=rate.length;
        int arr[]=new int[n];
        Arrays.fill(arr,1);
       //  left to right scan
       for(int i=1;i<n;i++)
       {
        if(rate[i]>rate[i-1])
           arr[i]=arr[i-1]+1;
       }
       //right to left scan
       for(int i=n-2;i>=0;i--)
       {
        if(rate[i]>rate[i+1])
          arr[i]=Math.max(arr[i],arr[i+1]+1);
       }
       for(int i=0;i<arr.length;i++)
       {
        ans+=arr[i];
       }
        return ans;
    }
}