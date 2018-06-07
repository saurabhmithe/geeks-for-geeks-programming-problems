package Arrays.Array;

public class MergeNIntoMPlusN {
    public static void main(String[] args) {
        int[] m = {1, 3, 5, 7, 9, 0, 0, 0, 0};
        int[] n = {2, 4, 6, 8};

        int[] mergedByLinear = linear(m.clone(), n);
        for (int num : mergedByLinear) {
            System.out.print(num + " ");
        }

    }

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
