import java.util.HashSet;
import java.util.Set;

class Solution {

    public int robotSim(int[] commands, int[][] obstacles) {
        // Define directions: North (0, 1), East (1, 0), South (0, -1), West (-1, 0)
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0; // Start facing north

        // Set of obstacle positions
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        int x = 0, y = 0; // Start at (0, 0)
        int maxDistanceSquared = 0;

        for (int command : commands) {
            if (command == -2) {
                // Turn left 90 degrees
                dir = (dir + 3) % 4;
            } else if (command == -1) {
                // Turn right 90 degrees
                dir = (dir + 1) % 4;
            } else {
                // Move forward `command` steps
                for (int step = 0; step < command; step++) {
                    int nextX = x + directions[dir][0];
                    int nextY = y + directions[dir][1];

                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        break; // Hit an obstacle, stop moving
                    } else {
                        x = nextX;
                        y = nextY;
                        maxDistanceSquared = Math.max(maxDistanceSquared, x * x + y * y);
                    }
                }
            }
        }

        return maxDistanceSquared;
    }

}