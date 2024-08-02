class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        
        for(Integer ky : mp.keySet()){
            if(mp.get(ky)>1){
                return ky;
            }
        }
        
        return 0;
        
    }
}