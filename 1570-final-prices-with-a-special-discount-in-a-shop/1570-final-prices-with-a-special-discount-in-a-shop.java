class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack=new Stack<>();
        int n=prices.length;
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&prices[stack.peek()]>=prices[i]){
                prices[stack.peek()]-=prices[i];
                stack.pop();
            }
            stack.add(i);
        }
        return prices;
    }
}