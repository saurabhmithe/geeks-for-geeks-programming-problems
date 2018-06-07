package Arrays.Array;

public class MaximumDifference {
    public static void main(String[] args) {
        int[] array = {2, 3, 10, 6, 4, 8, 1};
        int length = array.length;
        int maxDifferenceBruteforce = bruteForce(array, length);
        System.out.println(maxDifferenceBruteforce);

        int maxDifferenceLinear = linear(array, length);
        System.out.println(maxDifferenceLinear);
    }

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
