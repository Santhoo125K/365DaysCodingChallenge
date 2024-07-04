class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] merged = new int[n + m];
        
        int i = 0, j = 0, k = 0;
        
        // Merge nums1 and nums2 into the merged array
        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        
        // If there are remaining elements in nums1
        while (i < n) {
            merged[k++] = nums1[i++];
        }
        
        // If there are remaining elements in nums2
        while (j < m) {
            merged[k++] = nums2[j++];
        }
        
        // Calculate the median
        int totalLength = n + m;
        if (totalLength % 2 == 0) {
            // Even number of elements, median is average of middle two elements
            return (merged[totalLength / 2 - 1] + merged[totalLength / 2]) / 2.0;
        } else {
            // Odd number of elements, median is the middle element
            return merged[totalLength / 2];
        }
    }
}
