package io.github.ashwins93.quick;

import io.github.ashwins93.support.ArraySwapper;
import io.github.ashwins93.support.ArrayWrapper;
import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {
    @Test
    public void canSortStrings() {
        final var actualNames = new String[]{
                "Johnson", "Wilkinson",
                "Wilson", "Abraham", "Dagobert"
        };
        final var expected = new String[]{
                "Abraham", "Dagobert",
                "Johnson", "Wilkinson", "Wilson"
        };
        var sort = new QuickSort<String>();
        sort.setComparator(String::compareTo);
        sort.setSwapper(new ArraySwapper<>(actualNames));
        sort.sort(new ArrayWrapper<>(actualNames));

        Assert.assertArrayEquals(actualNames, expected);
    }
}
