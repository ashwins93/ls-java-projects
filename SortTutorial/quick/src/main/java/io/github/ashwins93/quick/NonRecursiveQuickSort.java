package io.github.ashwins93.quick;

import io.github.ashwins93.interfaces.Sortable;
import io.github.ashwins93.interfaces.Swapper;

import java.util.Comparator;
import java.util.LinkedList;

public class NonRecursiveQuickSort<E> {
    private final Comparator<E> comparator;
    private final Swapper swapper;
    private final Partitioner<E> partitioner;

    public NonRecursiveQuickSort(Comparator<E> comparator, Swapper swapper) {
        this.comparator = comparator;
        this.swapper = swapper;
        this.partitioner = new Partitioner<>(comparator, swapper);
    }

    private static class StackElement {
        final int begin;
        final int fin;

        public StackElement(int begin, int fin) {
            this.begin = begin;
            this.fin = fin;
        }
    }

    public void qsort(Sortable<E> sortable) {
        var stack = new LinkedList<StackElement>();
        stack.add(new StackElement(0, sortable.size() - 1));

        while(!stack.isEmpty())  {
            var it = stack.remove(0);
            if(it.begin < it.fin) {
                var pivot = sortable.get(it.begin);
                var cutIndex = partitioner.partition(sortable, it.begin, it.fin, pivot);
                if(cutIndex == it.begin) {
                    cutIndex++;
                }
                stack.add(0, new StackElement(it.begin, cutIndex - 1));
                stack.add(0, new StackElement(cutIndex, it.fin));
            }
        }
    }
}
