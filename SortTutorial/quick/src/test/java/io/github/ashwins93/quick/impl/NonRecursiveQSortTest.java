package io.github.ashwins93.quick.impl;

import io.github.ashwins93.support.ArraySwapper;
import io.github.ashwins93.support.ArrayWrapper;
import org.junit.Assert;
import org.junit.Test;

public class NonRecursiveQSortTest {
    @Test
    public void canSortIntArrays() {
        var arrayToSort = new Integer[]{5, 4, 3, 2, 0, 7, 6};
        var arrayWrapped = new ArrayWrapper<Integer>(arrayToSort);
        var swapper = new ArraySwapper<Integer>(arrayToSort);
        var qsort = new NonRecursiveQSort<Integer>((a, b) -> a - b, swapper);
        qsort.qsort(arrayWrapped);

        Assert.assertArrayEquals(arrayToSort, new Integer[]{0, 2, 3, 4, 5, 6, 7});
    }
}
