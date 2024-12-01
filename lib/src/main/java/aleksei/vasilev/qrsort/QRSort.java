package aleksei.vasilev.qrsort;

import java.lang.Math;

public class QRSort {
    public static void sort(final int[] A) {
        if (A.length == 0 || A.length == 1) return;

        int min = A[0];
        int max = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] < min) {
                min = A[i];
            }
            if (A[i] > max) {
                max = A[i];
            }
        }

        final int d = (int) Math.sqrt(max - min + 1);
        final int maxQuot = (max - min) / d;

        final int[] B = new int[A.length];
        final int[] Cr = new int[d];
        final int[] R = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            R[i] = (A[i] - min) % d;
        }

        if (maxQuot == 0) {
            countingSort(A, B, Cr, R, true);
            return;
        }

        countingSort(A, B, Cr, R, false);

        final int[] Cq = new int[maxQuot + 1];
        final int[] Q = new int[B.length];

        for (int i = 0; i < B.length; i++) {
            Q[i] = (B[i] - min) / d;
        }

        countingSort(B, A, Cq, Q, false);
    }

    public static void countingSort(
        final int[] A,
        final int[] B,
        final int[] C,
        final int[] K,
        final boolean copyBtoA
    ) {
        for (int i = 0; i < A.length; i++) {
            C[K[i]]++;
        }

        for (int k = 1; k < C.length; k++) {
            C[k] += C[k-1];
        }

        for (int i = A.length - 1; i >= 0; i--) {
            int k = K[i];
            B[C[k]-1] = A[i];
            C[k]--;
        }

        if (!copyBtoA) { return; }

        System.arraycopy(B, 0, A, 0, A.length);
    }
}
