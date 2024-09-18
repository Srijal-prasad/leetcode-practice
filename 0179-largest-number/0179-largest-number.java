class Solution {
    public String largestNumber(int[] nums) {/*
        int left = 0; 
        int right = nums.length-1;

        StringBuilder s = new StringBuilder();
        while(left <= right){
            if(nums[left]<nums[right]){
                s.append(Integer.toString(nums[right]));
                right--;
            }else{
                s.append(Integer.toString(nums[left]));
                left++;
            }
        }
        return s.toString();*/

        String[] s = new String[nums.length]; 
        for(int i=0; i<nums.length; i++){
            s[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(s, (a,b) -> (b + a).compareTo(a + b));
        
        return s[0].equals("0") ? "0" : String.join("",s);
    }
}