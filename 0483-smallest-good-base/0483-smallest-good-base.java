class Solution {
    public String smallestGoodBase(String n) {
         long num = Long.parseLong(n);
         long x=1;
         for(int i=62;i>=1;i--) //Limiting the search range
         {
              if((x<<i)<num)
              {
                  long res=findresult(num,i);
                  if(res!=0)
                   return String.valueOf(res);
              }
         }
         return String.valueOf(num-1);
    }
    public long findresult(long num,long bit)
    {
         double n = (double) num;
        long start=1,end=(long) (Math.pow(n, 1.0 / bit) + 1);
        while(start<=end)
        {   
            long mid=start+(end-start)/2;
            long sum=1,curr=1;
            for(int i=1;i<=bit;i++)
            {
                curr*=mid;
                sum+=curr;
            }
            if(sum==num)
             return mid;
            else if(sum<num)
             start=mid+1;
             else
             end=mid-1;
        }
        return 0;
    }
}