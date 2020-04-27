package io.github.ashwins93.quick;

import io.github.ashwins93.interfaces.Swapper;
import io.github.ashwins93.support.ArraySwapper;
import io.github.ashwins93.support.ArrayWrapper;
import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {
    @Test
    public void canSortIntArrays() {
        var arrayToSort = new Integer[]{5, 4, 3, 2, 0, 7, 6};
        var arrayWrapped = new ArrayWrapper<Integer>(arrayToSort);
        var swapper = new ArraySwapper<Integer>(arrayToSort);
        var qsort = new QuickSort<Integer>((a, b) -> a - b, swapper);
        qsort.qsort(arrayWrapped, 0, arrayWrapped.size() - 1);

        Assert.assertArrayEquals(arrayToSort, new Integer[]{0, 2, 3, 4, 5, 6, 7});
    }
}
