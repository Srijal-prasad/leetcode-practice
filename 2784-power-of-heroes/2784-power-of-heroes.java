class Solution {
       int mod = 1000000007;
    public int sumOfPower(int[] nums) {
        long ans=0;
        long prev=0;
        Arrays.sort(nums);
        for(long num: nums){
            ans = (ans + ((num*num)%mod * num) %mod + ((num*num)%mod * prev)%mod)%mod;
            prev = (prev*2+num)%mod;
        }
        return (int)ans;
    }
}