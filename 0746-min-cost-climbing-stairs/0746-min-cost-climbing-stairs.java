class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] M = new int[cost.length+1];
        M[0] = 0;
        M[1] = 0;
        for(int i=2; i<=cost.length; i++){
            M[i] = Math.min(M[i-1]+cost[i-1],M[i-2]+cost[i-2]);
        }
        return M[cost.length];
    }
}