class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = 0;
        int pos = 0;
        int neg = 0;

        for (int num : nums) {
            pos += num;
            neg += num;

            if (pos < 0) {
                pos = 0;
            }

            if (neg > 0) {
                neg = 0;
            }

            max = Math.max(Math.max(pos, Math.abs(neg)), max);
        }

        return max;
    }
}