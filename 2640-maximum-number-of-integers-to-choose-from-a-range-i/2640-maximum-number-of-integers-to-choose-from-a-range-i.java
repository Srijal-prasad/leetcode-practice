class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int currentNumber = 1;
        long currentSum = 0;
        int bannedIndex = 0;
        int validCount = 0;

        // Sort the banned list for efficient checking
        Arrays.sort(banned);

        // Iterate through numbers from 1 to n, adding them to the sum if they're valid
        while (currentNumber <= n && currentSum + currentNumber <= maxSum) {
            if (bannedIndex < banned.length && banned[bannedIndex] == currentNumber) {
                while (bannedIndex < banned.length && banned[bannedIndex] == currentNumber) {
                    bannedIndex++;
                }
                currentNumber++;
            } else {
                validCount++;
                currentSum += currentNumber;
                currentNumber++;
            }
        }

        return validCount;
    }
}