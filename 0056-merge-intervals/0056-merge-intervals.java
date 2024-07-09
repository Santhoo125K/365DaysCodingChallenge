class Solution {
    public int[][] merge(int[][] intervals) {
		 Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Step 2: Use a list to collect merged intervals
        List<int[]> merged = new ArrayList<>();
        
        // Step 3: Iterate through sorted intervals and merge them
        for (int[] interval : intervals) {
            // If the merged list is empty or if the current interval does not overlap with the last interval in merged list
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Overlapping intervals, merge the current interval with the last interval in merged list
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        
        // Step 4: Convert list to array and return
        return merged.toArray(new int[merged.size()][]);
	}
}