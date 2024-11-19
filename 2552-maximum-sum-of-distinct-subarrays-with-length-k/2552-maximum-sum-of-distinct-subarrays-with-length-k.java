class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        if (k > nums.length) {
            return 0;
        }

        long maxSum = 0;
        long currentSum = 0;
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);

            if (i >= k) {
                int leftElement = nums[i - k];
                currentSum -= leftElement;
                countMap.put(leftElement, countMap.get(leftElement) - 1);
                if (countMap.get(leftElement) == 0) {
                    countMap.remove(leftElement);
                }
            }
            if (countMap.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }
}