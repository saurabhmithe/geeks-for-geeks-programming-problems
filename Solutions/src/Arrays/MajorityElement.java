package Arrays;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class MajorityElement {

    /*

    Write a function which takes an array and prints the majority element (if it exists),
    otherwise prints “No Majority Element”. A majority element in an array A[] of size n
    is an element that appears more than n/2 times (and hence there is at most one such element).

    */

    public static void main(String[] args) {
        int[] array = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int length = array.length;
        System.out.println(bruteForce(array, length));
        System.out.println(hashTable(array, length));
        System.out.println(boyerMoore(array, length));
    }

    /**
     * Find all the unique elements in the given array using a Set.
     * For each of the unique elements, count the total number of times
     * that element has appeared in the given array.
     * <p>
     * If the count is greater than n/2, return the element as the majority element.
     * If no such element is found with count greater than n/2, return -1.
     * <p>
     * Time - O(n^2)
     * Space - O(n)
     */
    private static int bruteForce(int[] a, int n) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i : a) {
            hashSet.add(i);
        }

        Iterator<Integer> setIterator = hashSet.iterator();
        while (setIterator.hasNext()) {
            int num = setIterator.next();
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (a[i] == num) {
                    count += 1;
                }
                if (count > n / 2) {
                    return num;
                }
            }
        }
        return -1;
    }

    /**
     * For each of the elements in the given array, maintain the count in a Hash Table.
     * If the count for any element becomes greater than n/2, return the element.
     * If no element has a count greater than n/2, return -1.
     * <p>
     * Time - O(n)
     * Space - O(n)
     */
    private static int hashTable(int[] a, int n) {
        Hashtable<Integer, Integer> hashTable = new Hashtable<>();
        for (int i : a) {
            if (hashTable.containsKey(i)) {
                hashTable.put(i, hashTable.get(i) + 1);
                if (hashTable.get(i) > n / 2) {
                    return i;
                }
            } else {
                hashTable.put(i, 1);
            }
        }
        return -1;
    }

    /**
     * Best approach for this problem.
     * <p>
     * This is a special algorithm which assumes that the majority element would always be present.
     * This can be modified by adding a second pass which could be used to check whether majority element is present.
     * This algorithm is called as Boyer-Moore voting algorithm which operates on the concept of weight.
     * For each element in the given array, that element is considered as a candidate to be a majority element.
     * A count is maintained and incremented as long as we see the same element in succession.
     * Whenever a new element is seen, the count for the current element is decremented.
     * If multiple new elements are seen, the count of current candidate will be 0 and a new candidate is chosen.
     * The element assigned as a candidate at the end of the iteration is returned as a majority element.
     * <p>
     * Time - O(n)
     * Space - O(1)
     */
    private static int boyerMoore(int[] a, int n) {
        int count = 0;
        int candidate = 0;

        for (int num : a) {
            if (count == 0) {
                candidate = num;
            }
            if (candidate == num) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        return candidate;
    }
}
