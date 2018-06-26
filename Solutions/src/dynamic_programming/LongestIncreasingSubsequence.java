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
     */
    public int LIS(int[] a) {
        // Create the maximum sub-sequence sum array
        int[] arr = new int[a.length];

        for (int i = 0; i < arr.length; i++) {
            // Setting individual sum for each element which is base case
            arr[i] = 1;

        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    // Adding sum of previous smaller element with 1 and assigning to sum of current element
                    if (arr[i] < arr[j] + 1) arr[i] = arr[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int max = lis.LIS(a);
        System.out.println(max);
    }

}
