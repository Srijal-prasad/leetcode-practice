class Solution {
    public int maximumLength(String s) {
        // Create a map to store substrings and their frequency
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();

        // Iterate through each character in the string
        for (int i = 0; i < n; i++) {
            int j = i; // Initialize the end pointer of the substring
            do {
                // Extract the substring from index i to j
                String ss = s.substring(i, j + 1);
                // Update the frequency of the substring in the map
                map.put(ss, map.getOrDefault(ss, 0) + 1);

                // Check if the next character is the same as the current one
                // If so, extend the substring by incrementing j
                if (j < n - 1 && s.charAt(j) == s.charAt(j + 1)) {
                    j++;
                } else {
                    // Break the loop if the substring cannot be extended
                    break;
                }
            } while (j < n); // Continue while within the bounds of the string
        }

        // Initialize a variable to store the longest valid substring
        String ssmax = "";

        // Iterate through the map to find the longest substring
        // that appears at least 3 times
        for (String ss : map.keySet()) {
            if (map.get(ss) >= 3 && ss.length() > ssmax.length()) {
                ssmax = ss;
            }
        }

        // If no valid substring is found, return -1
        // Otherwise, return the length of the longest valid substring
        return ssmax.equals("") ? -1 : ssmax.length();
    }
}