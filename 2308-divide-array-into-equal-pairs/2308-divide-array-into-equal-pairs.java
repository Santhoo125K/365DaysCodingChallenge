class Solution {
    public boolean divideArray(int[] nums) {
        int[] freq= new int[501];
        for(int i : nums){
            freq[i]++;
        }
        for(int i : nums){
            if(freq[i]%2 !=0) return false;
        }
        return true;
    }
}