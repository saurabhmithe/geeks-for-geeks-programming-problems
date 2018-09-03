package Arrays;

public class MaximumDifference {
    public static void main(String[] args) {
        int[] array = {2, 3, 10, 6, 4, 8, 1};
        int length = array.length;
        int maxDifferenceBruteforce = bruteForce(array, length);
        System.out.println(maxDifferenceBruteforce);

        int maxDifferenceLinear = linear(array, length);
        System.out.println(maxDifferenceLinear);
    }

    /**
     * This is an inefficient approach.
     * For each element, we look at all the elements after that elements and calculate the max difference.
     * Then we move on to the next element and repeat the same.
     * We do this for all the elements.
     * <p>
     * Time Complexity - O(n^2)
     * Space Complexity - O(1)
     */
    private static int bruteForce(int[] a, int n) {
        int maxDifference = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                int difference = a[j] - a[i];
                if (difference > maxDifference) {
                    maxDifference = difference;
                }
            }
        }
        return maxDifference;
    }

    /**
     * This is the best approach for this problem.
     * We linearly traverse the array and maintain the minimum value we have seen so far.
     * Additionally, we maintain the maximum difference between the current value and the minimum value.
     * If we come across a value smaller than the minimum value, we update the minimum.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    private static int linear(int[] a, int n) {
        int min = 0;
        int max = 0;

        for (int i = 1; i < n; i++) {
            if (a[i] < a[min] && i < max) {
                min = i;
            }
            if (a[i] > a[max] && i > max) {
                max = i;
            }
        }
        return a[max] - a[min];
    }

}
