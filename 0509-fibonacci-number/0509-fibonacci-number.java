// class Solution {
    
//     public int fib(int n) {
        
//         if(n<=1) return n;
        
//         int dp[] = new int[n+1];
//         Arrays.fill(dp,-1);
        
//         return dp[n] = fib(n-1) + fib(n-2);
//     }
// }


import java.util.HashMap;
import java.util.Map;

class Solution {
    
    private static Map<Integer, Integer> memo = new HashMap<>();

    public int fib(int n) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        // Check if the result is already computed and stored in the map
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        // Compute the Fibonacci number and store it in the map
        int result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);

        return result;
    }
}
