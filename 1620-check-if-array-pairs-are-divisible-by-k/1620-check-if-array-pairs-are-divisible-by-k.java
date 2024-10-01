class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n=arr.length;
        int freq[]=new int[k];
        for(int i=0;i<n;i++)
        {
            int rem=arr[i]%k;
             if(rem<0)
             {
                rem=rem+k;
             }
             freq[rem]++;
        }
        if(freq[0]%2!=0)
          return false;

        for(int i=1;i<k;i++)
        {
            if(freq[i]!=freq[k-i])
            return false;
        }
        return true;
    }
}