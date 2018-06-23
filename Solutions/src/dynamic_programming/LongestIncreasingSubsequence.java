package dynamic_programming;

public class LongestIncreasingSubsequence {

    /*

    Given an unsorted array of integers, find the length of longest increasing subsequence.

    Example:
    Input: [10,9,2,5,3,7,101,18]
    Output: 4
    Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

    Note:
    There may be more than one LIS combination, it is only necessary for you to return the length.
    Your algorithm should run in O(n2) complexity.
    Follow up: Could you improve it to O(n log n) time complexity?

     */

    /**
     * Time Complexity - O(n^2)
     * Space Complexity - O(n)
     * <p>
     * Runtime on LeetCode - 62ms
     * Runtime beats 6.90% of Java submissions
     */
    public int LISNaive(int[] a) {
        int[] arr = new int[a.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < i; j++) {
                if (a[i] > a[j]) {
                    if (arr[i] < arr[j] + 1) arr[i] = arr[j] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }
        return max;
    }

}
