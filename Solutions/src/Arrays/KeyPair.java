package Arrays;

import java.util.Arrays;

public class KeyPair {

	/*

	Given an array A[] and a number x, check for pair in A[] with sum as x

	*/

    public static void main(String[] args) {
        int[] a = {1, 4, 45, 6, 10, -8};
        KeyPair keyPair = new KeyPair();
        boolean isPairPresent = keyPair.isPairPresent(a, 16);
        System.out.println(isPairPresent);
    }

    /**
     * Best approach without using additional space.
     * We sort the array in ascending order.
     * Maintaining two pointers, one at the beginning and the other at the very far end,
     * we check if they add up to the target value. If yes, we have found the pair.
     * If their sum is less than the target value, we increment the beginning pointer to next position.
     * Then we check again for the sum. If the sum if greater than the target value, we decrement the
     * end pointer. We continue this until we find the pair or the pointers cross each other.
     * <p>
     * Time Complexity - O(nlogn)
     * Space Complexity - O(1)
     */
    private boolean isPairPresent(int[] array, int sum) {
        Arrays.sort(array);
        int arrayLength = array.length;
        int first = 0;
        int last = arrayLength - 1;
        while (first < last) {
            if (array[first] + array[last] == sum) {
                return true;
            } else if (array[first] + array[last] < sum) {
                first++;
            } else if (array[first] + array[last] > sum) {
                last--;
            }
        }
        return false;
    }

}
