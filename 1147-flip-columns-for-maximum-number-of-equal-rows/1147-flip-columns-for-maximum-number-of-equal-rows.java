class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patternCount = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder normalizedPattern = new StringBuilder();

            // Normalize the row
            int firstElement = row[0];
            for (int cell : row) {
                normalizedPattern.append(cell == firstElement ? '0' : '1');
            }

            // Count the pattern
            String key = normalizedPattern.toString();
            patternCount.put(key, patternCount.getOrDefault(key, 0) + 1);
        }

        // Find the maximum count of any pattern
        int maxRows = 0;
        for (int count : patternCount.values()) {
            maxRows = Math.max(maxRows, count);
        }

        return maxRows;
    }
}