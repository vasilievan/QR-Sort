package aleksei.vasilev.qrsort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class QRSortTest {
    @Test
    public void sort() {

        final int[] expected = {0, 1, 2, 5, 12, 73};
        final int[] a = {73, 0, 12, 1, 5, 2};
        QRSort.sort(a);
        assertArrayEquals(expected, a);

        final int[] b = {2, 12, 0, 5, 1, 73};
        QRSort.sort(b);
        assertArrayEquals(expected, b);

        final int[] c = {0, 12, 5, 2, 73, 1};
        QRSort.sort(c);
        assertArrayEquals(expected, c);

        final int[] d = {1, 12, 5, 73, 2, 0};
        QRSort.sort(d);
        assertArrayEquals(expected, d);

        final int[] expected2 = {0, 0, 0, 0, 0, 1};
        final int[] e = expected2.clone();
        QRSort.sort(e);
        assertArrayEquals(expected2, e);

        final int[] f = {0, 0, 1, 0, 0, 0};
        QRSort.sort(f);
        assertArrayEquals(expected2, f);

        final int[] expected3 = {0, 0, 0};
        final int[] g = {0, 0, 0};
        QRSort.sort(g);
        assertArrayEquals(expected3, g);

        final int[] expected4 = {1, 2, 5};
        final int[] h = {5, 1, 2};
        QRSort.sort(h);
        assertArrayEquals(expected4, h);

        final int[] i = {2, 1, 5};
        QRSort.sort(i);
        assertArrayEquals(expected4, i);

        final int[] j = {1, 2, 5};
        QRSort.sort(j);
        assertArrayEquals(expected4, j);

        final int[] k = {2, 5, 1};
        QRSort.sort(k);
        assertArrayEquals(expected4, k);

        final int[] l = {};
        QRSort.sort(l);
        assertArrayEquals(new int[0], l);

        final int[] m = { 1 };
        QRSort.sort(m);
        assertArrayEquals(new int[] { 1 }, m);

        final int[] n = { 2, 1 };
        QRSort.sort(n);
        assertArrayEquals(new int[] { 1, 2 }, n);

        Random random = new Random();

        int numberLimit = 1000;

        for (int o = 0; o < 100; o++) {

            final int[] p = new int[o];

            for (int index = 0; index < p.length; index++) {
                p[index] = random.nextInt(numberLimit);
            }

            int[] expected5 = p.clone();
            Arrays.sort(expected5);
            QRSort.sort(p);
            assertArrayEquals(expected5, p);
        }
    }
}