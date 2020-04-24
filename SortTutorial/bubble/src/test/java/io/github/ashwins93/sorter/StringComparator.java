package io.github.ashwins93.sorter;

import java.util.Comparator;

public class StringComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        final String f = (String) o1;
        final String s = (String) o2;
        return f.compareTo(s);
    }
}
