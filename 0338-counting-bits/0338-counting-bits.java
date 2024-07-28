class Solution {

    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        countBits(arr, 1, 1);
        return arr; 
    }

    public void countBits(int[] arr, int n, int ones) {
        if (n >= arr.length) {
            return;
        }
        arr[n] = ones;
        // shift left means * 2, ones will still be the same
        countBits(arr, n << 1, ones);
        // * 2 + 1 means number of ones will increase by 1
        countBits(arr, (n << 1) + 1, ones + 1);
    }

    public int[] countBitsIter(int n) {
        int[] arr = new int[n + 1];
        for (int i = 1; i < arr.length; i++) {
            // number of 1s at i is the same as number of 1s at i/2 because
            // last bit is 0
            arr[i] = i % 2 == 0 ? arr[i / 2] : 1 + arr[i / 2];
        }
        return arr;
    }
}