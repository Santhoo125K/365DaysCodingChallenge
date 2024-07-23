class Solution {
    public int maxArea(int[] height) {
        int start = 0, ans = 0, end = height.length - 1;
        while (start < end) {
            int h=Math.min(height[start],height[end]);
            int water=(end-start)*h;
            ans=Math.max(ans,water);
            while(height[start]<=h && start<end){
                start++;
            }
            while(height[end]<=h && start<end){
                end--;
            
            }
        }
        return ans;
    }
}