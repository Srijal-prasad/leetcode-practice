class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int[] increase = new int[nums.length];
        int[] decrease = new int[nums.length];
        Arrays.fill(increase,1);
        Arrays.fill(decrease,1);
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i])
                increase[i] = Math.max(increase[i],increase[j]+1);
            }
        }
        for(int i=nums.length-2;i>=0;i--){
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]<nums[i])
                decrease[i] = Math.max(decrease[i],decrease[j]+1);
            }
        }
        //  System.out.println(Arrays.toString(increase));
        //  System.out.println(Arrays.toString(decrease));
        int answer=0;
        for(int i=1;i<nums.length-1;i++){
            if(increase[i]!=1 && decrease[i]!=1)
            answer = Math.max(answer,increase[i]+decrease[i]-1);
        }
        return nums.length-answer;
    }
}