class Solution {
    public String fractionAddition(String expression) {
        // If the expression doesn't start with a minus, prepend a plus for easier parsing
        if (expression.charAt(0) != '-') {
            expression = '+' + expression;
        }

        int numeratorSum = 0;
        int denominatorProduct = 1;

        int i = 0;
        while (i < expression.length()) {
            // Parse the sign
            char sign = expression.charAt(i);
            i++;

            // Parse the numerator
            int numerator = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                numerator = numerator * 10 + (expression.charAt(i) - '0');
                i++;
            }
            if (sign == '-') {
                numerator = -numerator;
            }

            // Skip the '/' character
            i++;

            // Parse the denominator
            int denominator = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                denominator = denominator * 10 + (expression.charAt(i) - '0');
                i++;
            }

            // Compute the sum of numerators with a common denominator
            // a/b+c/d=(a*d+c*b)/(b*d);
            numeratorSum = numeratorSum * denominator + numerator * denominatorProduct;
            denominatorProduct *= denominator;
 
            // Simplify the fraction by dividing by the GCD
            int gcd = gcd(Math.abs(numeratorSum), denominatorProduct);
            numeratorSum /= gcd;
            denominatorProduct /= gcd;
        }

        return numeratorSum + "/" + denominatorProduct;
    }

    // Helper function to compute the Greatest Common Divisor (GCD)
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}