package Backtracking;

public class StringPermutations {

    // Write a program to print all permutations of a given string.

    // A permutation, also called an “arrangement number” or “order,” is a rearrangement of the elements of
    // an ordered list S into a one-to-one correspondence with S itself. A string of length n has n! permutation.

    // Source: Mathword(http://mathworld.wolfram.com/Permutation.html)

    // Below are the permutations of string ABC.
    // ABC ACB BAC BCA CBA CAB


    public void stringPermutations(String str, String prefix) {
        if (str.length() == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < str.length(); i++) {
                stringPermutations(str.substring(0, i) + str.substring(i + 1, str.length()), prefix + str.charAt(i));
            }
        }
    }

}
