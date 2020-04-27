package io.github.ashwins93.sorter;

import io.github.ashwins93.interfaces.Sortable;

import java.util.ArrayList;

public class ArrayListSortable<E> implements Sortable<E> {
    final ArrayList<E> actualNames;

    ArrayListSortable(ArrayList<E> actualNames) {
        this.actualNames = actualNames;
    }

    @Override
    public int size() {
        return actualNames.size();
    }

    @Override
    public E get(int index) {
        return actualNames.get(index);
    }
}
