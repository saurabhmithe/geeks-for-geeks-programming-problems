package dynamic_programming;

public class LongestPallindromicSubsequence {

    // Given a sequence, find the length of the longest palindromic subsequence in it.
    // If the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB”
    // is the longest palindromic subseuqnce in it. “BBBBB” and “BBCBB” are also
    // palindromic subsequences of the given sequence, but not the longest ones.

    public int lps(String s) {
        int n = s.length();
        int[][] values = new int[n][n];

        // Since each character is a Palindrome of length 1, initialize array with appropriate values.
        for (int i = 0; i < n; i++) {
            values[i][i] = 1;
        }

        // Since we already covered palindromes of length 1, we will start looking from length 2
        for (int l = 2; l <= n; l++) {
            for (int j = 0; j < n - l + 1; j++) {
                int i = j + l - 1;
                if (s.charAt(j) != s.charAt(i)) {
                    values[j][i] = Math.max(values[j][i - 1], values[j + 1][i]);
                } else {
                    values[j][i] = 2 + values[j + 1][i - 1];
                }
            }
        }

        return values[0][n - 1];
    }

}
