package io.github.ashwins93.sorter;

import io.github.ashwins93.interfaces.Swapper;

import java.util.ArrayList;

public class ArrayListSwapper<E> implements Swapper {
    final ArrayList<E> actualNames;

    ArrayListSwapper(ArrayList<E> actualNames) {
        this.actualNames = actualNames;
    }

    @Override
    public void swap(int i, int j) {
        final E tmp = actualNames.get(i);
        actualNames.set(i, actualNames.get(j));
        actualNames.set(j, tmp);
    }
}
