public class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x; // Square root of 0 or 1 is the number itself.
        }
        
        // Initialize low and high bounds for binary search
        int low = 0, high = x, result = 0;
        
        // Binary search to find the floor of the square root
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // If mid * mid == x, mid is the exact square root
            if (mid == x / mid) {
                return mid;
            }
            // If mid * mid is less than x, move to the right half
            if (mid < x / mid) {
                low = mid + 1;
                result = mid; // Store the potential answer
            } 
            // If mid * mid is more than x, move to the left half
            else {
                high = mid - 1;
            }
        }
        
        return result; // The result is the floored square root
    }
}
