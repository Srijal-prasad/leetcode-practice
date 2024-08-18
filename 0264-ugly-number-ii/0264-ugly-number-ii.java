class Solution {
    public int nthUglyNumber(int n) {
       int ugly[]=new int[n];
        ugly[0] = 1;
        int idx2=0,idx3=0,idx5=0;
        int nextmultiple2=2;
        int nextmultiple3=3;
        int nextmultiple5=5;
        for(int i=1;i<ugly.length;i++)
        {
            int nextuglynum=Math.min(nextmultiple2,Math.min(nextmultiple3,nextmultiple5));
             ugly[i]=nextuglynum;
            if(nextuglynum==nextmultiple2)
            {
                 nextmultiple2=ugly[++idx2]*2;
            }
            if(nextuglynum==nextmultiple3)
            {
                  nextmultiple3=ugly[++idx3]*3;
            }
            if(nextuglynum==nextmultiple5)
            {
               nextmultiple5=ugly[++idx5]*5;
            }
        }
        return ugly[n-1]; 
    }
}