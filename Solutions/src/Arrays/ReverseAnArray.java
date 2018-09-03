package Arrays;

public class ReverseAnArray {
    public static void main(String[] args) {
        ReverseAnArray reverseAnArray = new ReverseAnArray();

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int length = array.length;
        int[] reversedArrayNew = reverseAnArray.newArray(array, length);
        for (int num : reversedArrayNew) {
            System.out.print(num + " ");
        }
        System.out.println();
        int[] reversedArraySwap = reverseAnArray.swap(array.clone(), 0, length - 1);
        for (int num : reversedArraySwap) {
            System.out.print(num + " ");
        }
        System.out.println();
        reverseAnArray.swapRecursion(array, 0, length - 1);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    /**
     * Create a new empty array.
     * Start filling the new array with elements from the original array but in reversed order.
     * <p>
     * Time - O(n)
     * Space - O(n)
     */
    public int[] newArray(int[] a, int n) {
        int[] newArray = new int[n];
        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            newArray[index++] = a[i];
        }
        return newArray;
    }

    /**
     * Best approach for this problem.
     * <p>
     * Have two pointers pointing to the first and the last element respectively.
     * Swap the first and the last element. Increment the lower pointer and decrement the higher pointer.
     * Repeat until lower does not cross the higher pointer.
     * <p>
     * Time - O(n)
     * Space - O(1)
     */
    public int[] swap(int[] a, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
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
     * <p>
     * Time - O(n)
     * Space - O(1)
     */
    public void swapRecursion(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int temp = a[low];
        a[low] = a[high];
        a[high] = temp;
        low += 1;
        high -= 1;
        swapRecursion(a, low, high);
    }
}
