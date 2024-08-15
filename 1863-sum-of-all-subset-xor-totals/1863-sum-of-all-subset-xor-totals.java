class Solution {
    public int subsetXORSum(int[] nums) {
        
        int n = nums.length;
        int sumOfXOR = 0;
        
        int totalSubsets  = 1 << n ;
        
        for(int i=0; i<totalSubsets; i++){
            int currentXOR = 0;
            
            for(int j=0; j<n; j++){
                if((i & (1<<j)) != 0){
                    currentXOR ^= nums[j];
                }
            }
            
            sumOfXOR += currentXOR;
        }
        
        return sumOfXOR;
    }
}