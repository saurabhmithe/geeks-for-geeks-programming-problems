package dynamic_programming;

public class EditDistance {

    /*

    Given two strings str1 and str2 and below operations that can performed on str1. Find
    minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

    Insert
    Remove
    Replace
    All of the above operations are of equal cost.

    Examples:
    Input:   str1 = "geek", str2 = "gesek"
    Output:  1
    We can convert str1 into str2 by inserting a 's'.

    Input:   str1 = "cat", str2 = "cut"
    Output:  1
    We can convert str1 into str2 by replacing 'a' with 'u'.

    Input:   str1 = "sunday", str2 = "saturday"
    Output:  3

    Last three and first characters are same.  We basically
    need to convert "un" to "atur".  This can be done using
    below three operations.
    Replace 'n' with 'r', insert t, insert a

    */

    public static void main(String[] args) {
        String s1 = "geek";
        String s2 = "gesek";
        EditDistance editDistance = new EditDistance();
        int distance = editDistance.minDistance(s1.toCharArray(), s2.toCharArray());
        System.out.println(distance);
    }

    /**
     * Time Complexity - O(n^2)
     * Space Complexity - O(n^2)
     */
    public int minDistance(char[] s1, char[] s2) {
        int[][] mem = new int[s1.length + 1][s2.length + 1];

        for (int row = 0; row < s1.length + 1; row++) {
            mem[row][0] = row;
        }
        for (int col = 0; col < s2.length + 1; col++) {
            mem[0][col] = col;
        }

        for (int row = 1; row < s1.length + 1; row++) {
            for (int col = 1; col < s2.length + 1; col++) {
                if (s1[row - 1] == s2[col - 1]) mem[row][col] = mem[row - 1][col - 1];
                else
                    mem[row][col] = 1 + Math.min(mem[row - 1][col - 1], Math.min(mem[row - 1][col], mem[row][col - 1]));
            }
        }

        return mem[s1.length][s2.length];
    }

}
