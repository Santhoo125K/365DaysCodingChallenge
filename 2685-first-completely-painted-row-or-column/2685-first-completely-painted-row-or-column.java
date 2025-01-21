class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Step 1: Create a mapping from value to its position in the matrix
        Map<Integer, int[]> valueToPosition = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                valueToPosition.put(mat[i][j], new int[]{i, j});
            }
        }

        // Step 2: Arrays to track painted cells in each row and column
        int[] rowsPainted = new int[m];
        int[] colsPainted = new int[n];

        // Step 3: Iterate through arr and paint the matrix
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int[] position = valueToPosition.get(value);
            int row = position[0];
            int col = position[1];

            // Increment the count for the corresponding row and column
            rowsPainted[row]++;
            colsPainted[col]++;

            // Check if this row or column is fully painted
            if (rowsPainted[row] == n || colsPainted[col] == m) {
                return i; // Return the smallest index where the condition is met
            }
        }

        // If no row or column is fully painted, return -1 (should not happen per constraints)
        return -1;
    }
}
