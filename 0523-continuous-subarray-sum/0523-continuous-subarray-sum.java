class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
         int n=nums.length,sum=0;;
         HashMap<Integer,Integer>map=new HashMap<>();
         map.put(0,0);
         for(int i=0;i<n;i++)
         {
            sum+=nums[i];
            if(map.containsKey(sum%k))
            {
             if(map.get(sum%k)<i)
               return true;
            }
            else
              map.put(sum%k, i+1);
         }
         return false;
    }
}