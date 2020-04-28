package io.github.ashwins93.quick;

import io.github.ashwins93.interfaces.Sortable;
import io.github.ashwins93.quick.impl.QSort;
import io.github.ashwins93.support.AbstractSort;

public class QuickSort<E> extends AbstractSort<E> {
    @Override
    public void sort(Sortable<E> collection) {
        final var n = collection.size();
        final var qsort = new QSort<E>(comparator, swapper);
        qsort.qsort(collection, 0, n - 1);
    }
}
