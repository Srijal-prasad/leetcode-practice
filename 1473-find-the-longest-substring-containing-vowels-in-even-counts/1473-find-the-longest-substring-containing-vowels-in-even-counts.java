class Solution {
    public int findTheLongestSubstring(String s) {
        int vowels[] = new int[128];
        vowels['a'] = 1;
        vowels['e'] = 2;
        vowels['i'] = 4;
        vowels['o'] = 8;
        vowels['u'] = 16;

        int first_occurance[] = new int[32];
        Arrays.fill(first_occurance, -2);
        first_occurance[0] = -1;
        int result = 0;
        int bitmask = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                bitmask ^= vowels[ch];
            }

            if(first_occurance[bitmask] != -2) {
                result = Math.max(result, i - first_occurance[bitmask]);
            }
            else {
                first_occurance[bitmask] = i;
            }
        }

        return result;
    }
}