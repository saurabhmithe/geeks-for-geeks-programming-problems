package dynamic_programming;

public class PartitionProblem {

    public static void main(String[] args) {
        int[] a = {1, 5, 11, 5};
        PartitionProblem partitionProblem = new PartitionProblem();
        boolean isPossible = partitionProblem.partition(a);
        System.out.println(isPossible);
    }

    public boolean partition(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) sum += a[i];

        if (sum % 2 != 0) return false; // cannot partition into two since sum is odd

        // a 2-D array to store solutions to sub-problems
        boolean[][] p = new boolean[a.length + 1][(sum / 2) + 1];

        for (int row = 0; row < a.length; row++) p[row][0] = true;
        for (int col = 1; col < sum / 2; col++) p[0][col] = false;

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (a[i - 1] < j) {
                    p[i][j] = p[i - 1][j]; // carry over the previous value
                } else {
                    // OR of previous value or previous best for remaining value when current value is subtracted
                    p[i][j] = p[i - 1][j] || p[i - 1][a[i - 1] - j];
                }
            }
        }

        return p[a.length][sum / 2];
    }

}
