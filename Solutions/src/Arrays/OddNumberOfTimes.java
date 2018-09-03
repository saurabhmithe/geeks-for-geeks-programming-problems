package Arrays;

import java.util.Hashtable;

public class OddNumberOfTimes {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 3, 1, 3};
        int length = array.length;
        System.out.println(bruteForce(array, length));
        System.out.println(hashTable(array, length));
        System.out.println(xor(array, length));
    }

    /**
     * For each element in the given array, count the total number of occurences using another loop.
     * If the count is odd, return the current element.
     * <p>
     * Time - O(n^2)
     * Space - O(1)
     */
    private static int bruteForce(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (a[i] == a[j]) {
                    count += 1;
                }
            }
            if (count % 2 == 1) {
                return a[i];
            }
        }
        return -1;
    }

    /**
     * For each element in the given array, maintain a
     * count of the number of occurrences using a Hash Table.
     * Then iterating over the Hash Table entries, return the
     * element whose count is odd.
     * <p>
     * Time - O(n)
     * Space - O(n)
     */
    private static int hashTable(int[] a, int n) {
        Hashtable<Integer, Integer> hashTable = new Hashtable<>();
        for (int num : a) {
            if (hashTable.containsKey(num)) {
                hashTable.put(num, hashTable.get(num) + 1);
            } else {
                hashTable.put(num, 1);
            }
        }
        for (int key : hashTable.keySet()) {
            if (hashTable.get(key) % 2 == 1) {
                return key;
            }
        }
        return -1;
    }

    /**
     * Best approach for this problem.
     * <p>
     * This method leverages the properties of bitwise XOR operation.
     * The property that we are using here is n ^ 0 = n and n ^ n = 0.
     * So if we XOR all the elements in the given array, the elements
     * appearing even number of times would result in total of 0 in XOR.
     * The element appearing odd number of times would be left in the XOR result.
     * The result would be returned.
     * <p>
     * Time - O(n)
     * Space - O(1)
     */
    private static int xor(int[] a, int n) {
        int result = 0;
        for (int num : a) {
            result = result ^ num;
        }
        return result;
    }
}
