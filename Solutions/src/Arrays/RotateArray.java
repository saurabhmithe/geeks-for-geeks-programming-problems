package Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int length = array.length;
        int d = 2;
        int[] rotatedOneByOne = oneByOne(array.clone(), length, d);

        for (int num : rotatedOneByOne) {
            System.out.print(num + " ");
        }

        System.out.println();

        int[] rotatedTempArray = tempArray(array.clone(), length, d);
        for (int num : rotatedTempArray) {
            System.out.print(num + " ");
        }

        System.out.println();

        int[] rotatedReversalArray = reversing(array.clone(), length, d);
        for (int num : rotatedReversalArray) {
            System.out.print(num + " ");
        }
    }

    /**
     * Here we shift the elements to the left one by one.
     * So we take the first element, keep it in a temp variable.
     * Then we shift all the elements to the front and copy the temp value at the last position.
     * We repeat this step for d elements.
     * <p>
     * Time Complexity - O(n * d)
     * Space Complexity - O(1)
     */
    private static int[] oneByOne(int[] a, int n, int d) {
        while (d > 0) {
            int i = 1;
            int temp = a[0];
            while (i < n) {
                a[i - 1] = a[i];
                i += 1;
            }
            a[i - 1] = temp;
            d -= 1;
        }
        return a;
    }

    /**
     * Here we take an additional temporary array of size n.
     * We first copy d elements starting from first position from the given array to the temp array.
     * Then we shift the remaining n - d elements in the given array to the first positions.
     * Then we copy the d elements from the temp array to the given array at the end.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(n)
     */
    private static int[] tempArray(int[] a, int n, int d) {
        int[] temp = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = a[i];
        }
        for (int i = d; i < n; i++) {
            a[i - d] = a[i];
        }
        int index = 0;
        for (int i = n - d; i < n; i++) {
            a[i] = temp[index++];
        }
        return a;
    }

    /**
     * Best approach for this problem.
     * <p>
     * To left-rotate the array by d elements, we reverse the first d elements, and then the next n - d elements.
     * After this, we reverse the entire array. Right-rotation follows a similar logic, however, the partition is
     * now n - d and d instead of d, n - d.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    private static int[] reversing(int[] a, int n, int d) {
        ReverseAnArray reverseAnArray = new ReverseAnArray();
        reverseAnArray.swap(a, 0, d - 1);
        reverseAnArray.swap(a, d, n - 1);
        reverseAnArray.swap(a, 0, n - 1);
        return a;
    }

}
