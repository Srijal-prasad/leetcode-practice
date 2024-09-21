class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        // Iterate from 1 to 9
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, result);
        }
        return result;
    }
    
    // Helper method for DFS
    private void dfs(int curr, int n, List<Integer> result) {
        if (curr > n) return;  // Stop recursion if current number is greater than n
        result.add(curr);      // Add current number to the result list
        
        // Try to append digits (0-9) to the current number
        for (int i = 0; i <= 9; i++) {
            if (curr * 10 + i > n) break;  // Stop if the number exceeds n
            dfs(curr * 10 + i, n, result); // Recursive call
        }
    }
}