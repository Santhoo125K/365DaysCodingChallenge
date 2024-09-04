import java.util.HashSet;
import java.util.Set;

class Solution {

    public int robotSim(int[] commands, int[][] obstacles) {

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0; 

        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        int x = 0, y = 0; 
        int maxDistanceSquared = 0;

        for (int command : commands) {
            if (command == -2) {
                dir = (dir + 3) % 4;
            } else if (command == -1) {
                dir = (dir + 1) % 4;
            } else {
                for (int step = 0; step < command; step++) {
                    int nextX = x + directions[dir][0];
                    int nextY = y + directions[dir][1];

                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        break; 
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