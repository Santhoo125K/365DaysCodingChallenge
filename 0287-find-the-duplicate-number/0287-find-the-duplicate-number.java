class Solution {
    public int findDuplicate(int[] nums) {
        
        boolean check[] = new boolean[nums.length];
        
        for(int i:nums){
            if(check[i]) return i;
            else check[i]=true;
        }
        
        return 0;
    }
}
