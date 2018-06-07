package Arrays.Array;

public class RotateArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int length = array.length;
        int d= 2;
        int[] rotatedOneByOne = oneByOne(array.clone(), length, d);

        for (int num : rotatedOneByOne) {
            System.out.print(num + " ");
        }

        System.out.println();

        int[] rotatedTempArray = tempArray(array.clone(), length, d);
        for (int num : rotatedTempArray) {
            System.out.print(num + " ");
        }
    }

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

    private static int[] juggling(int[] a, int n, int d) {
        return a;
    }
}
