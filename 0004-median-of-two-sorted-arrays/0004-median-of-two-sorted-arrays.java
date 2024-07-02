// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
// //         int mergeArray[] = new int[nums1.length + nums2.length];
        
// //         System.arraycopy(nums1, 0, mergeArray, 0, nums1.length);
// //         System.arraycopy(nums2, 0, mergeArray, nums1.length, nums2.length);
        
// //         Arrays.sort(mergeArray);
        
// //         int len = mergeArray.length;
        
        
// //         if(mergeArray.length % 2 == 0){
// //             return ((mergeArray[len/2 - 1]) + (mergeArray[len/2]))/2.0;
// //         }else{
// //             return mergeArray[len/2];
// //         } 
        
        
//     }
// }

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr[] = new int[nums1.length + nums2.length];
        for(int i=0,j=0;i<arr.length;i++){
            if(i>=nums1.length)
                arr[i]=nums2[j++];
            else
                arr[i]=nums1[i];
        }
        Arrays.sort(arr);
        double ans = 0.0;
        
        if(arr.length % 2 == 0)
            ans = (double) (arr[arr.length/2 -1] + arr[arr.length/2]) / 2;
        else
            ans = arr[arr.length/2];
        
        return ans;
    }
}