class Solution {
    public static long findScore(int[] nums) {
        // Create a list of pairs (value, index) to sort by value and handle ties by index
        List<int[]> elements = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            elements.add(new int[]{nums[i], i});
        }

        // Sort the elements by value, then by index
        elements.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        // Marked array to keep track of marked indices
        boolean[] marked = new boolean[nums.length];

        long score = 0;
        for (int[] element : elements) {
            int value = element[0];
            int index = element[1];

            // If already marked, skip
            if (marked[index]) continue;

            // Add to score
            score += value;

            // Mark the chosen element and its adjacent ones
            marked[index] = true;
            if (index > 0) marked[index - 1] = true;
            if (index < nums.length - 1) marked[index + 1] = true;
        }

        return score;
    }
}

