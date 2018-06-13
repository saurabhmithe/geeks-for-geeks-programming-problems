package dynamic_programming;

public class MaximumSumIncreasingSubsequence {

    public static void main(String[] args) {
        int[] a = {1, 101, 2, 3, 100, 4, 5};
        MaximumSumIncreasingSubsequence increasingSubsequence = new MaximumSumIncreasingSubsequence();
        int maxSum = increasingSubsequence.maxSum(a, a.length);
        System.out.println(maxSum);
    }

    public int maxSum(int[] a, int n) {
        // This is where we would store the maximum sum to be returned.
        int max = 0;

        // This is the memoization array where we would keep max sum up to that particular index.
        int[] msis = new int[n];

        // Populating the max sum array assuming each digit has a sum equal to itself.
        // This is the case where the array is sorted in descending order.
        for (int i = 0; i < n; i++) {
            msis[i] = a[i];
        }

        // Calculate the maximum sum for each sub-sequence imposing the increasing condition.
        for (int next = 1; next < n; next++) {
            for (int prev = 0; prev < next; prev++) {
                if (a[next] > a[prev] && msis[next] < msis[prev] + a[next]) {
                    msis[next] = msis[prev] + a[next];
                }
            }
        }

        // Return the maximum value from the calculated sub-sequence sums.
        for (int i = 0; i < msis.length; i++) {
            if (max < msis[i]) max = msis[i];
        }
        return max;

    }
}
