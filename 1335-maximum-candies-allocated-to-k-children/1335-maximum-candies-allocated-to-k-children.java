
import java.util.Arrays;

class Solution {
    public int maximumCandies(int[] candies, long k) {

        Arrays.sort(candies);

        int l = 1, h = candies[candies.length - 1];

        while (l <= h) {

            int m = l + (h - l) / 2;
            if (canAllocate(candies, k, m)) {
                l = m + 1;
            } else {

                h = m - 1;
            }

        }

        return l - 1;
    }

    public boolean canAllocate(int[] candies, long k, int i) {

        long maxCanpCh = 0;
        for (int candy : candies) {

            maxCanpCh += candy / i;
        }
        if (maxCanpCh >= k)
            return true;

        return false;

    }

}