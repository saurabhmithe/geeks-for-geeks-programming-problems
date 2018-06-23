package dynamic_programming;

public class MinCostPath {

    /*

    Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost
    of minimum cost path to reach (m, n) from (0, 0). Each cell of the matrix represents a cost to
    traverse through that cell. Total cost of a path to reach (m, n) is sum of all the costs on that
    path (including both source and destination). You can only traverse down, right and diagonally
    lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and
    (i+1, j+1) can be traversed. You may assume that all costs are positive integers.

     */

    /**
     * Time Complexity - O(m * n)
     * Space Complexity - O(m * n)
     */
    public static int minCost(int[][] cost, int m, int n) {

        int[][] tc = new int[m + 1][n + 1];
        tc[0][0] = cost[0][0];
        // Popluate the first column
        // Populate the first row
        for (int i = 1; i <= m; i++) {
            tc[i][0] = cost[i][0] + tc[i - 1][0];
        }
        for (int i = 1; i <= n; i++) {
            tc[0][i] = cost[0][i] + tc[0][i - 1];
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                tc[i][j] = cost[i][j] + min(tc[i][j - 1], tc[i - 1][j], tc[i - 1][j - 1]);
            }
        }
        return tc[m][n];

    }

    public static int min(int x, int y, int z) {
        return x < y ? x < z ? x : z : y < z ? y : z;
    }
}
