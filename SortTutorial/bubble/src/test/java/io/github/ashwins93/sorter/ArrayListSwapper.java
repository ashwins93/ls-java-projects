package io.github.ashwins93.sorter;

import io.github.ashwins93.interfaces.Swapper;

import java.util.ArrayList;

public class ArrayListSwapper implements Swapper {
    final ArrayList actualNames;

    ArrayListSwapper(ArrayList actualNames) {
        this.actualNames = actualNames;
    }

    @Override
    public void swap(int i, int j) {
        final Object tmp = actualNames.get(i);
        actualNames.set(i, actualNames.get(j));
        actualNames.set(j, tmp);
    }
}
