class Solution {
    public boolean validMountainArray(int[] arr) {
        int size = arr.length;
        if (size < 3) {
            return false;
        }

        int i = 0;

        // walk up
        while (i + 1 < size && arr[i] < arr[i + 1]) {
            i++;
        }

        // peak can't be first or last
        if (i == 0 || i == size - 1) {
            return false;
        }

        // walk down
        while (i + 1 < size && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == size - 1;
    }
}
