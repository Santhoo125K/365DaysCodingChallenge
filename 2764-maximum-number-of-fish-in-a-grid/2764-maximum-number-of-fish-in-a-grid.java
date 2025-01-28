
class Solution {
     public int findMaxFish(int[][] grid) {

        var max = new int[]{0};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    var sum = new int[]{0};
                    var visited = new int[grid.length][grid[0].length];
                    helper(i, j, grid, sum, visited);
                    max[0] = Math.max(max[0], sum[0]);
                }
            }
        }
        return max[0];
    }

    private void helper(int i, int j, int[][] grid, int[] sum, int[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j] == 1) {
            return;
        }
        visited[i][j] = 1;
        sum[0] = sum[0] + grid[i][j];

        helper(i - 1, j, grid, sum, visited);
        helper(i + 1, j, grid, sum, visited);
        helper(i, j - 1, grid, sum, visited);
        helper(i, j + 1, grid, sum, visited);
    }
}