class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mergeArray[] = new int[nums1.length + nums2.length];
        
        System.arraycopy(nums1, 0, mergeArray, 0, nums1.length);
        System.arraycopy(nums2, 0, mergeArray, nums1.length, nums2.length);
        
        Arrays.sort(mergeArray);
        
        int len = mergeArray.length;
        
        
        if(mergeArray.length % 2 == 0){
            return ((mergeArray[len/2 - 1]) + (mergeArray[len/2]))/2.0;
        }else{
            return mergeArray[len/2];
        } 
    }
}