package Arrays;

public class SegregateZerosAndOnes {
    public static void main(String[] args) {
        int[] array = {1, 0, 0, 1, 1, 0, 1, 1};
        int length = array.length;

        int[] segregaredBySwap = swap(array.clone(), length);
        for (int num : segregaredBySwap) {
            System.out.print(num + " ");
        }
    }

    /**
     * We are essentially shifting all the 0s to the initial positions.
     * We maintain a pointer to the first position and loop through the entire array.
     * If the value at the current position is 0, we swap it with the value at the pointer.
     * Else, we keep it as it is  and move to the next element.
     * So the pointer guides where the next 0 value would be kept.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    private static int[] swap(int[] a, int n) {
        int currentPointer = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                int temp = a[i];
                a[i] = a[currentPointer];
                a[currentPointer++] = temp;
            }
        }
        return a;
    }

}
