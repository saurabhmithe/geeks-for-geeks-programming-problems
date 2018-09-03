package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array A[] and a number x, check for pair in A[] with sum as x
 */
public class PairWithSumX {
    public static void main(String args[]) {
        int x = 17;
        int[] array = {5, 8, 2, 1, 6, 3, 7, 9, 4};
        int length = array.length;
        System.out.println(bruteForce(array, length, x));
        System.out.println(sorting(array, length, x));
        System.out.println(hashSet(array, length, x));
    }

    /**
     * For each element in the given array, check the entire array for the
     * number that could be added to current number so as to get a sum of x
     *
     * Time - O(n^2)
     * Space - O(1)
     */
    private static boolean bruteForce(int[] a, int n, int x) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                if (a[i] + a[j] == x) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Sort the given array.
     * Have two pointers each at start and the end respectively.
     * If the sum of the values at current pointers is less than x, increment lower pointer.
     * If the sum of the values at current pointers is more than x, decrement the upper pointer.
     * This approach works because it takes advantage of the properties in a sorted array.
     *
     * Time - O(nlgn)
     * Space - O(1)
     */
    private static boolean sorting(int[] a, int n, int x) {
        Arrays.sort(a);
        int i = 0;
        int j = n - 1;
        while ( i < j) {
            if (a[i] + a[j] == x) {
                return true;
            } else {
                if (a[i] + a[j] < x) {
                    i += 1;
                } else {
                    j += 1;
                }
            }
        }
        return false;
    }

    /**
     * For each element in the given array, check if the pair-counterpart is present in the Hash Set.
     * If the counterpart is present, it indicates that the pair results in sum equal to x.
     * If the counterpart is not present, put the current element in the Hash Set.
     * This inserted element could later be found to be a counterpart for another element.
     *
     * Time - O(n)
     * Space - O(n)
     */
    private static boolean hashSet(int[] a, int n, int x) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : a) {
            if (hashSet.contains(x - num)) {
                return true;
            } else {
                hashSet.add(num);
            }
        }
        return false;
    }
}
