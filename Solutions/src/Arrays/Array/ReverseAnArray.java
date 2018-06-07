package Arrays.Array;

public class ReverseAnArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int length = array.length;
        int[] reversedArrayNew = newArray(array, length);
        for (int num: reversedArrayNew) {
            System.out.print(num + " ");
        }
        System.out.println();
        int[] reversedArraySwap = swap(array.clone(), length);
        for (int num: reversedArraySwap) {
            System.out.print(num + " ");
        }
        System.out.println();
        swapRecursion(array, 0, length - 1);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    /**
     * Create a new empty array.
     * Start filling the new array with elements from the original array but in reversed order.
     *
     * Time - O(n)
     * Space - O(n)
     */
    private static int[] newArray(int[] a, int n) {
        int[] newArray = new int[n];
        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            newArray[index++] = a[i];
        }
        return newArray;
    }

    /**
     * Have two pointers pointing to the first and the last element respectively.
     * Swap the first and the last element. Increment the lower pointer and decrement the higher pointer.
     * Repeat until lower does not cross the higher pointer.
     *
     * Time - O(n)
     * Space - O(1)
     */
    private static int[] swap(int[] a, int n) {
        int i = 0;
        int j = n - 1;
        while ( i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return a;
    }

    /**
     * This is a recursive approach to the swapping technique.
     * Swap the first and last elements with each other.
     * Then keep on repeating the same method for a smaller
     * array with the starting and ending element not considered.
     *
     * Time - O(n)
     * Space - O(1)
     */
    private static void swapRecursion(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int temp = a[low];
        a[low] = a[high];
        a[high] = temp;
        low += 1;
        high -=1;
        swapRecursion(a, low, high);
    }
}
