package Arrays.Array;

public class SegregateZerosAndOnes {
    public static void main(String[] args) {
        int[] array = {1, 0, 0, 1, 1, 0, 1, 1};
        int length = array.length;

        int[] segregaredBySwap = swap(array.clone(), length);
        for (int num : segregaredBySwap) {
            System.out.print(num + " ");
        }
    }

    private static int[] swap(int[] a, int n) {
        int p1 = 0;
        int p2 = n - 1;

        while (p1 < p2) {
            if (a[p2] == 0 && a[p1] == 1) {
                int temp = a[p1];
                a[p1] = a[p2];
                a[p2] = temp;
                p1 +=1 ;
                p2 -= 1;
            }
            if (a[p2] == 1) {
                p2 -= 1;
            }
            if (a[p1] == 0) {
                p1 += 1;
            }
        }
        return a;
    }
}
