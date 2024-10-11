class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        // Create an array with friends' arrival and departure times along with their indices
        int[][] friends = new int[n][3];
        for (int i = 0; i < n; i++) {
            friends[i][0] = times[i][0]; // arrival time
            friends[i][1] = times[i][1]; // departure time
            friends[i][2] = i;           // friend index
        }

        // Sort friends by arrival time
        Arrays.sort(friends, Comparator.comparingInt(a -> a[0]));

        // Priority queue for available chairs (min-heap)
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableChairs.offer(i);
        }

        // Priority queue for occupied chairs ordered by departure time
        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Iterate through friends in the order of their arrival
        for (int[] friend : friends) {
            int arrival = friend[0];
            int leaving = friend[1];
            int index = friend[2];

            // Free up chairs when friends leave before the current arrival time
            while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= arrival) {
                availableChairs.offer(occupiedChairs.poll()[1]);
            }

            // The smallest available chair
            int chair = availableChairs.poll();
            // If the current friend is the target friend, return the chair number
            if (index == targetFriend) {
                return chair;
            }

            // Add the chair to the occupied queue with its corresponding leaving time
            occupiedChairs.offer(new int[]{leaving, chair});
        }

        return -1;
    }
}