class Solution {
    public int maxDistance(int[] position, int m) {
        int ans=1,n=position.length;
       Arrays.sort(position);
       int start=1,end=position[n-1]-position[0];
       while(start<=end)
       {
        int mid=start+(end-start)/2;
        if(helper(position,mid,m)==true)
        {
            ans=mid;
            start=mid+1;
        }
        else
           end=mid-1;
       }
       return ans;
    }
    public boolean helper(int pos[],int mid,int m)
    {
         int balls=1;
         int prev=pos[0];
         for(int i=1;i<pos.length;i++)
         {
            if(pos[i]-prev>=mid)
            {
                balls++;
                prev=pos[i];
            }
         }
          return balls>=m;
    }
}