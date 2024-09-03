class Solution {
    public int getLucky(String s, int k) {
        return sumOfDigitsAfterConvert(s,k);
    }

    public int sumOfDigitsAfterConvert(String s, int k) {
        String sb = "";
        for (int i = 0; i < s.length(); i++) {
            sb += s.charAt(i) - 'a' + 1;
        }

        int sum =  0;
        for (char ch : sb.toCharArray()) {
            sum += ch -'0';
        }

        for (int i = 1; i < k; i++) {
            sum = sumOfDigits(sum);
        }
        return sum;
    }

    private int sumOfDigits(int sum) {
        int res = 0;
        while (sum > 0) {
            res += sum % 10;
            sum /= 10;
        }
        return res;
    }
}