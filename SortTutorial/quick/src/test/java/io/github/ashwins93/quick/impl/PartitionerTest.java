package io.github.ashwins93.quick.impl;

import io.github.ashwins93.support.ArrayWrapper;
import org.junit.Assert;
import org.junit.Test;
import io.github.ashwins93.support.ArraySwapper;

public class PartitionerTest {
    private void assertSmallElements(Integer[] array, int cutIndex, Integer pivot) {
        for(int i = 0; i < cutIndex; i++) {
            Assert.assertTrue(array[i] < pivot);
        }
    }

    private void assertLargeElements(Integer[] array, int cutIndex, Integer pivot) {
        for(int i = cutIndex; i < array.length; i++) {
            Assert.assertTrue(array[i] >= pivot);
        }
    }

    @Test
    public void partitionsIntArray() {
        final var partitionThis = new Integer[]{0, 7, 6, 9, 1, 2, 5};
        final var swapper = new ArraySwapper<>(partitionThis);
        final Integer pivot = 6;
        final var partitioner = new Partitioner<Integer>(
                (a, b) -> a - b,
                swapper);
        final int cutIndex = partitioner.partition(
                new ArrayWrapper<>(partitionThis),
                0,
                partitionThis.length - 1,
                pivot);
        Assert.assertEquals(4, cutIndex);
        assertSmallElements(partitionThis, cutIndex, pivot);
        assertLargeElements(partitionThis, cutIndex, pivot);
    }

}
