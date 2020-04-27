package io.github.ashwins93.sorters;

import io.github.ashwins93.interfaces.Sort;
import io.github.ashwins93.interfaces.SortSupport;
import io.github.ashwins93.interfaces.Sortable;
import io.github.ashwins93.interfaces.Swapper;

import java.util.Comparator;

public class BubbleSort<E> implements Sort<E>, SortSupport<E> {
    private Swapper swapper;
    private Comparator<E> comparator;

    public void sort(Sortable<E> collection) {
        var n = collection.size();
        while(n > 1) {
            for(int j = 0; j < n - 1; j++) {
                if(comparator.compare(collection.get(j), collection.get(j + 1)) > 0) {
                    swapper.swap(j, j + 1);
                }
            }
            n--;
        }

    }

    public Swapper getSwapper() {
        return swapper;
    }

    public void setSwapper(Swapper swapper) {
        this.swapper = swapper;
    }

    public Comparator<E> getComparator() {
        return comparator;
    }

    public void setComparator(Comparator<E> comparator) {
        this.comparator = comparator;
    }
}
