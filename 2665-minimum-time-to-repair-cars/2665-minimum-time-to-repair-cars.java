class Solution {
    public boolean check(int cars, int[] ranks, long time) {
        int l = ranks.length;
        for (int i = 0; i < l; i++) {
            cars -= (int) Math.sqrt(time / ranks[i]);
            if (cars <= 0) return true; 
        }
        return false;
    }

    public long repairCars(int[] ranks, int cars) {
        int l = ranks.length;
        long left = 1, right = 1L * cars * cars * ranks[0]; 
        long restime = right;

        while (left <= right) { 
            long mid = left + (right - left) / 2;

            if (check(cars, ranks, mid)) {
                restime = mid;
                right = mid - 1; 
            } else {
                left = mid + 1;
            }
        }
        return restime;
    }
}