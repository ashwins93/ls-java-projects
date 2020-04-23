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

        var names = new Sortable() {
            public int size() {
                return actualNames.size();
            }

            public Object get(int index) {
                return actualNames.get(index);
            }
        };

        class SwapActualNamesArrayElements implements Swapper {
            @Override
            public void swap(int i, int j) {
                final Object tmp = actualNames.get(i);
                actualNames.set(i, actualNames.get(j));
                actualNames.set(j, tmp);
            }
        }

        var stringCompare = new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                final String f = (String) o1;
                final String s = (String) o2;
                return f.compareTo(s);
            }
        };

        var sort = new BubbleSort();
        sort.setSwapper(new SwapActualNamesArrayElements());
        sort.setComparator(stringCompare);
        sort.sort(names);

        Assert.assertEquals(List.of(
                "Abraham", "Dagobert",
                "Johnson", "Wilkinson", "Wilson"),
                actualNames);

        return;
    }
}
