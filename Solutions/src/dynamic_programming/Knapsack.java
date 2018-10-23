package dynamic_programming;

public class Knapsack {

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        int maxWeight = knapsack.knapsack(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50);
        System.out.println(maxWeight);
    }

    public int knapsack(int[] v, int[] w, int W) {
        int[][] k = new int[v.length + 1][W + 1];

        for (int i = 0; i <= w.length; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    k[i][j] = 0; // first row or column
                } else if (w[i - 1] > j) {
                    // weight cannot be considered in current knapsack
                    // just copy the existing best weight for current knapsack
                    k[i][j] = k[i - 1][j];
                } else {
                    // weight can be considered in the current knapsack

                    // if we do not choose the current item, then the value of the
                    // knapsack would be the same as it was before

                    // if we do consider the current item, the value of the
                    // knapsack would be the value of the current item +
                    // the previous best value of the knapsack without the current weight

                    // we choose the maximum of both the options

                    k[i][j] = Math.max(v[i - 1] + k[i - 1][j - w[i - 1]], k[i - 1][j]);
                }
            }
        }
        return k[w.length][W];
    }

}
