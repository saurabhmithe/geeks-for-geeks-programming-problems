package dynamic_programming;

public class LongestCommonSubsequence {

    /*

    Given two sequences, find the length of longest subsequence present in both of them. Both the strings are of uppercase.

    Input:
    First line of the input contains no of test cases  T,the T test cases follow.
    Each test case consist of 2 space separated integers A and B denoting the size of string str1 and str2 respectively
    The next two lines contains the 2 string str1 and str2 .

    Output:
    For each test case print the length of longest  common subsequence of the two strings .

    Constraints:
    1<=T<=200
    1<=size(str1),size(str2)<=100

    Example:
    Input:
    2
    6 6
    ABCDGH
    AEDFHR
    3 2
    ABC
    AC

    Output:
    3
    2

    Explanation
    LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.

    LCS of "ABC" and "AC" is "AC" of length 2

     */


    /**
     * Time Complexity - O(m*n)
     * Space Complexity - O(m * n)
     */
    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    static int lcs(char[] X, char[] Y, int m, int n) {
        int[][] mem = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    mem[i][j] = 0;
                } else if (X[i - 1] == Y[j - 1]) {
                    mem[i][j] = 1 + mem[i - 1][j - 1];
                } else {
                    mem[i][j] = Math.max(mem[i - 1][j], mem[i][j - 1]);
                }
            }
        }
        return mem[m][n];
    }

    /* Utility function to get max of 2 integers */
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

}
