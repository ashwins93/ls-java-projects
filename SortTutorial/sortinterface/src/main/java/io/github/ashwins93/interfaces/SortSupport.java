package io.github.ashwins93.interfaces;

import java.util.Comparator;

public interface SortSupport<E> {
    void setSwapper(Swapper swapper);

    void setComparator(Comparator<E> comparator);
}
