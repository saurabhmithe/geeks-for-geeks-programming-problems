package Arrays;

public class MergeNIntoMPlusN {
    public static void main(String[] args) {
        int[] m = {1, 3, 5, 7, 9, 0, 0, 0, 0};
        int[] n = {2, 4, 6, 8};

        int[] mergedByLinear = linear(m.clone(), n);
        for (int num : mergedByLinear) {
            System.out.print(num + " ");
        }

    }

    /**
     * First we shift all the blank spaces in the larger array to the end.
     * Then we maintain two pointers at the end of both arrays where the actual values end.
     * And we also maintain an additional pointer to the far end of the larger array where we need to put the elements.
     * Now we compare values at both the pointers and put the value that is larger at the end pointer.
     * We continue this until the pointer in the smaller array reaches 0.
     * <p>
     * Time Complexity - O(n)
     * Space Complexity - O(1)
     */
    private static int[] linear(int[] m, int[] n) {

        int pointer = m.length - 1;
        for (int i = m.length - 1; i >= 0; i--) {
            if (m[i] != 0) {
                m[pointer--] = m[i];
                m[i] = 0;
            }
        }

        int mptr = 0;
        while (m[mptr] == 0) {
            mptr += 1;
        }
        int nptr = 0;
        int ptr = 0;

        while (ptr < m.length && nptr < n.length && mptr < m.length) {
            if (m[mptr] < n[nptr]) {
                m[ptr] = m[mptr];
                mptr += 1;
            } else {
                m[ptr] = n[nptr];
                nptr += 1;
            }
            ptr += 1;
        }

        return m;
    }

}
