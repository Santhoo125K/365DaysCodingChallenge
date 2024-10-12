class Solution {
    public int minGroups(int[][] intervals) {
        // Create separate arrays for start and end times
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        // Sort both arrays
        Arrays.sort(starts);
        Arrays.sort(ends);

        int maxGroups = 0;
        int activeIntervals = 0;
        int i = 0, j = 0;

        // Use two pointers to count active intervals
        while (i < n) {
            // If there is a start time before or at the current end time
            if (starts[i] <= ends[j]) {
                activeIntervals++; // A new interval starts
                maxGroups = Math.max(maxGroups, activeIntervals); // Update max groups
                i++; // Move to the next start time
            } else {
                activeIntervals--; // An interval ends
                j++; // Move to the next end time
            }
        }

        return maxGroups; // Return the maximum number of active intervals
    }
}