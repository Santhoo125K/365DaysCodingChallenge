class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        for(int arr[] : grid) {
            for(int i : arr) {
                sum += i;
                hm.put(i, hm.getOrDefault(i, 0) + 1);
            }
        }

        int a = 0, b = 0;
        for(int i : hm.keySet()) {
            if(hm.get(i) > 1) {
                a = i;
                break;
            }
        }
        int size = grid.length * grid.length;
        int tot = size * (size + 1) / 2;
        sum -= a;
        b = tot - sum;
        return new int[]{a, b};
    }
}