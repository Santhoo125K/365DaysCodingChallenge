class Solution {
    public long maximumSubarraySum(int[] nums, int k) { 
        int left = 0, right = 0;
        Set<Integer> set = new HashSet<>();
        long ans = 0;
        long sum = 0;

        while (right < nums.length) {
            // Adjust the window if a duplicate is found
            while (set.contains(nums[right])) {
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }

            // Add the current element to the window
            set.add(nums[right]);
            sum += nums[right];
            right++;

            // If the window size is k, consider updating the answer
            if (right - left == k) {
                ans = Math.max(ans, sum);
                
                // Prepare to slide the window
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
        }

        return ans;
    }
}