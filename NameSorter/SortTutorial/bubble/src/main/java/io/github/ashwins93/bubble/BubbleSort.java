package io.github.ashwins93.bubble;

import java.util.Comparator;

public class BubbleSort implements Sort, SortSupport {
    private Swapper swapper;
    private Comparator comparator;

    public void sort(Sortable collection) {
        int n = collection.size();
        while(n > 1) {
            for(int j = 0; j < n - 1; j++) {
                if(comparator.compare(collection.get(j), collection.get(j+1)) > 0) {
                    swapper.swap(j, j + 1);
                }
            }
            n--;
        }
    }

    public Swapper getSwapper() {
        return swapper;
    }

    public void setSwapper(Swapper swapper) {
        this.swapper = swapper;
    }

    public Comparator getComparator() {
        return comparator;
    }

    public void setComparator(Comparator comparator) {
        this.comparator = comparator;
    }
}
