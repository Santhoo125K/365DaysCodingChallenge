
class Solution {
    public int largestRectangleArea(int[] heights) {
        // Stack to store indices of histogram bars
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0; // Variable to store the maximum area
        int n = heights.length;

        // Traverse through the histogram bars
        for (int i = 0; i <= n; i++) {
            // Use 0 as height for the end boundary
            int currentHeight = (i == n) ? 0 : heights[i];

            // While stack is not empty and the current height is less than the height of the bar at the top of the stack
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()]; // Height of the bar to calculate area
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; // Width of the rectangle
                maxArea = Math.max(maxArea, height * width); // Update the maximum area
            }

            // Push the current index to the stack
            stack.push(i);
        }

        return maxArea; // Return the maximum area
    }
}
