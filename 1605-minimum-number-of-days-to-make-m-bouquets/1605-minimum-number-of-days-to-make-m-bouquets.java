class Solution {
    public boolean getcount(int bloomDay[],int m,int k,int mid)
    {
        int count=0;
        int noofbq=0;
        for(int i:bloomDay)
        {
           if(i<=mid)
           {
               count++;
           }
           else
           {
               noofbq+=(count/k);
               count=0;
           }
        }
        noofbq+=(count/k);
        return (noofbq>=m);
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        long val=(long)m*k;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        if(val>n)
         return -1;
        for(int i: bloomDay)
        {
            max=Math.max(max,i);
            min =Math.min(min,i);
        }
        int start=min;
        int end=max;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
               if(getcount(bloomDay,m,k,mid))
                end=mid-1;
            else
              start=mid+1;
        }
        return start;
    }
}