class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();

        int[] dpMin = new int[n];
        int[] dpMax = new int[n];

        dpMin[0] = arrays.get(0).get(0);
        dpMax[0] = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        for (int i = 1; i < n; i++) {
            int currMin = arrays.get(i).get(0);
            int currMax = arrays.get(i).get(arrays.get(i).size() - 1);

            maxDistance = Math.max(maxDistance, Math.abs(currMax - dpMin[i-1]));
            maxDistance = Math.max(maxDistance, Math.abs(dpMax[i-1] - currMin));

            dpMin[i] = Math.min(dpMin[i-1], currMin);
            dpMax[i] = Math.max(dpMax[i-1], currMax);
        }

        return maxDistance;
    }
}