class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1; // 1 for positive, -1 for negative

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                // Build the number
                number = number * 10 + (ch - '0');
            } else if (ch == '+') {
                // Apply the previous number and reset
                result += sign * number;
                number = 0;
                sign = 1; // Set sign to positive
            } else if (ch == '-') {
                // Apply the previous number and reset
                result += sign * number;
                number = 0;
                sign = -1; // Set sign to negative
            } else if (ch == '(') {
                // Push the current result and sign to stack for later use
                stack.push(result);
                stack.push(sign);
                // Reset result and sign for the new sub-expression
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                // Complete the current sub-expression
                result += sign * number;
                number = 0;
                // Multiply result by sign and add to the previous result
                result *= stack.pop(); // Pop the sign
                result += stack.pop(); // Pop the previous result
            }
        }
        // Add the last number
        result += sign * number;
        return result;
    }
}