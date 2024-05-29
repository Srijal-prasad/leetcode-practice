class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int min=Integer.MAX_VALUE;
        int profit=0,max_profit=0;
        for(int i=0;i<n;i++)
        {
            if(prices[i]<min)
            {
                min=prices[i];
            }

            profit=prices[i]-min;
            max_profit=Math.max(max_profit,profit);
        }
        return max_profit;
    }
}