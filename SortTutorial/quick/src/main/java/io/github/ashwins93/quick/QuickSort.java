package io.github.ashwins93.quick;

import io.github.ashwins93.interfaces.Sortable;
import io.github.ashwins93.interfaces.Swapper;

import java.util.Comparator;

public class QuickSort<E>  {
    private final Comparator<E> comparator;
    private final Swapper swapper;
    private final Partitioner<E> partitioner;

    public QuickSort(Comparator<E> comparator, Swapper swapper) {
        this.comparator = comparator;
        this.swapper = swapper;
        this.partitioner = new Partitioner<>(comparator, swapper);
    }

    public void qsort(Sortable<E> sortable, int start, int end) {
        if(start < end) {
            final E pivot = sortable.get(start);
            int cutIndex = partitioner.partition(sortable, start, end, pivot);
            if(cutIndex == start) {
                cutIndex++;
            }
            qsort(sortable, start, cutIndex - 1);
            qsort(sortable, cutIndex, end);
        }
    }
}
