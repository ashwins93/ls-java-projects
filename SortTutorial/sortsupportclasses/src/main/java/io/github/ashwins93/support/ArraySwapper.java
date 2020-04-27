package io.github.ashwins93.support;

import io.github.ashwins93.interfaces.Swapper;

public class ArraySwapper<E> implements Swapper {
    private final E[] array;

    public ArraySwapper(E[] array) {
        this.array = array;
    }

    public E[] getArray() {
        return array;
    }

    @Override
    public void swap(int i, int j) {
        E tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
