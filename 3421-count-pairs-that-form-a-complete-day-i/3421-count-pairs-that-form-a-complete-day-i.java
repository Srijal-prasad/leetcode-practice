class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int day = 0;
        for (int i = 0; i < hours.length - 1; i++) {
            for (int j = i + 1; j < hours.length; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) {
                    day++;
                }
            }
        }
        return day; 
    }
}