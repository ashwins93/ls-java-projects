package io.github.ashwins93.support;

import io.github.ashwins93.interfaces.Sort;
import io.github.ashwins93.interfaces.SortSupport;
import io.github.ashwins93.interfaces.Sortable;
import io.github.ashwins93.interfaces.Swapper;

import java.util.Comparator;

public abstract class AbstractSort<E> implements Sort<E>, SortSupport<E> {
    protected Comparator<E> comparator;
    protected Swapper swapper;


    public abstract void sort(Sortable<E> collection);

    @Override
    public void setSwapper(Swapper swapper) {
        this.swapper = swapper;
    }

    @Override
    public void setComparator(Comparator<E> comparator) {
        this.comparator = comparator;
    }
}
