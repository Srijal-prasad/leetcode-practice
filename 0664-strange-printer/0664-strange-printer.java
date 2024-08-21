class Solution {
    int n;
    int[][] dp;

    // Recursive function to calculate the minimum number of turns required
    int solve(int l, int r, String s) {
        // If the substring has only one character, it needs exactly one turn to print
        if (l == r)
            return 1;
        // If the left index exceeds the right index, no turns are needed
        if (l > r)
            return 0;
        // Return the result if it's already computed
        if (dp[l][r] != -1)
            return dp[l][r];

        // Move the index 'i' to skip all identical characters starting from 'l'
        int i = l + 1;
        while (i <= r && s.charAt(i) == s.charAt(l))
            i++;
        // If all characters from l to r are the same, only one turn is needed
        if (i == r + 1)
            return 1;

        // The basic case where we print the first segment and solve the rest
        int basic = 1 + solve(i, r, s);

        // Initialize with a large value to find the minimum
        int lalach = Integer.MAX_VALUE;

        // Try to minimize the turns by considering different segments
        for (int j = i; j <= r; j++) {
            if (s.charAt(j) == s.charAt(l))
                lalach = Math.min(solve(i, j - 1, s) + solve(j, r, s), lalach);
        }

        // Store and return the minimum turns required
        return dp[l][r] = Math.min(basic, lalach);
    }

    public int strangePrinter(String s) {
        n = s.length();
        dp = new int[n + 1][n + 1];
        // Initialize the DP table with -1 (indicating uncomputed values)
        for (int[] a : dp)
            Arrays.fill(a, -1);
        return solve(0, n - 1, s);
    }
}