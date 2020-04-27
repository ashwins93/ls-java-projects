package io.github.ashwins93.support;

import io.github.ashwins93.interfaces.Sortable;

public class ArrayWrapper<E> implements Sortable<E> {
    private final E[] array;

    public ArrayWrapper(E[] array) {
        this.array = array;
    }

    public E[] getArray() {
        return array;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public E get(int index) {
        return array[index];
    }
}
