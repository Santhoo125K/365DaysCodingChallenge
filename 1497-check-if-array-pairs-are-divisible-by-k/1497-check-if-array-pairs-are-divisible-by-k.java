class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] remainderCount = new int[k];
        
        // Step 2: Count frequencies of remainders
        for (int num : arr) {
            int remainder = ((num % k) + k) % k; // To handle negative numbers correctly
            remainderCount[remainder]++;
        }
        
        // Step 3: Check pairs
        // 3.1: Remainder 0 must be paired with itself, so count must be even
        if (remainderCount[0] % 2 != 0) {
            return false;
        }
        
        // 3.2: For other remainders, r and k-r must have the same count
        for (int i = 1; i <= k / 2; i++) {
            if (remainderCount[i] != remainderCount[k - i]) {
                return false;
            }
        }
        
        return true;
    }
}