package io.github.ashwins93.sorter;

import io.github.ashwins93.interfaces.Sortable;
import io.github.ashwins93.interfaces.Swapper;
import io.github.ashwins93.sorters.BubbleSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BubbleSortTest {
    @Test
    public void canSortStrings() {
        var actualNames = new ArrayList(Arrays.asList(
                "Johnson", "Wilson",
                "Wilkinson", "Abraham", "Dagobert"
        ));



        var names = new ArrayListSortable(actualNames);
        var sort = new BubbleSort();
        sort.setSwapper(new ArrayListSwapper(actualNames));
        sort.setComparator(new StringComparator());
        sort.sort(names);

        Assert.assertEquals(List.of(
                "Abraham", "Dagobert",
                "Johnson", "Wilkinson", "Wilson"),
                actualNames);

        return;
    }
}
