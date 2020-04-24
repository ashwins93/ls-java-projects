package io.github.ashwins93.sorter;

import io.github.ashwins93.interfaces.Sortable;

import java.util.ArrayList;

public class ArrayListSortable implements Sortable {
    final ArrayList actualNames;

    ArrayListSortable(ArrayList actualNames) {
        this.actualNames = actualNames;
    }

    @Override
    public int size() {
        return actualNames.size();
    }

    @Override
    public Object get(int index) {
        return actualNames.get(index);
    }
}
