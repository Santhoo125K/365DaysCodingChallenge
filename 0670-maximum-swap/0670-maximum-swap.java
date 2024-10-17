class Solution {
    public int maximumSwap(int num) {
        if (num < 10) return num; // No swap needed for single digit numbers
        
        // Convert the number into a character array (digits)
        char[] digits = Integer.toString(num).toCharArray();
        int n = digits.length;
        
        // Traverse each digit and try to find the best swap
        for (int i = 0; i < n - 1; ++i) {
            int maxDigitIdx = i;
            for (int j = i + 1; j < n; ++j) {
                if (digits[maxDigitIdx] <= digits[j]) {
                    maxDigitIdx = j;
                }
            }
            // If a larger digit is found that is not in the current position, swap
            if (maxDigitIdx != i && digits[maxDigitIdx] != digits[i]) {
                char temp = digits[i];
                digits[i] = digits[maxDigitIdx];
                digits[maxDigitIdx] = temp;
                break; // Only one swap is allowed, so break after the first swap
            }
        }
        
        // Convert the character array back to integer and return the result
        return Integer.parseInt(new String(digits));
    }
}