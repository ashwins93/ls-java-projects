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
        var actualNames = new ArrayList<>(Arrays.asList(
                "Johnson", "Wilson",
                "Wilkinson", "Abraham", "Dagobert"
        ));

        Sortable<String> names = new ArrayListSortable<>(actualNames);
        var sort = new BubbleSort<String>();
        sort.setSwapper(new ArrayListSwapper<>(actualNames));
        sort.setComparator(String::compareTo);
        sort.sort(names);

        Assert.assertEquals(List.of(
                "Abraham", "Dagobert",
                "Johnson", "Wilkinson", "Wilson"),
                actualNames);

        return;
    }

    @Test
    public void throwsWhateverComparatorDoes() {
        final ArrayList<String> actualNames = new ArrayList<>(List.of(
                "", "Wilson"
        ));
        final var names = new ArrayListSortable<>(actualNames);
        final var exception = new RuntimeException();
        final var sort = new BubbleSort<String>();
        sort.setComparator((a, b) -> {
            throw exception;
        });
        final Swapper neverInvoked = null;
        sort.setSwapper(neverInvoked);
        try {
            sort.sort(names);
        } catch (Exception e) {
            Assert.assertSame(exception, e);
            return;
        }
        Assert.fail();
    }
}
