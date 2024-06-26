class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n=nums.length,count=0,sum=0;
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
         for(int i=0;i<n;i++)
         {
            sum+=nums[i];
            int rem=sum%k;
            if(rem<0)
               rem+=k;
            if(map.containsKey(rem)){
                 count+=map.get(rem);
                 map.put(rem,map.get(rem)+1);
            }
            else
              map.put(rem,1);
         }
         return count;
    }
}