package io.github.ashwins93.main;

import io.github.ashwins93.quick.QuickSort;
import io.github.ashwins93.support.ArraySwapper;
import io.github.ashwins93.support.ArrayWrapper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        final var fileName = args[0];
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            final var lines = new LinkedList<String>();
            String line;
            while((line = br.readLine()) != null) {
                lines.add(line);
            }
            String[] lineArray = lines.toArray(new String[0]);
            var sort = new QuickSort<String>();
            sort.setComparator(String::compareTo);
            sort.setSwapper(new ArraySwapper<>(lineArray));
            sort.sort(new ArrayWrapper<>(lineArray));

            for (final String outline: lineArray) {
                System.out.println(outline);
            }

        } finally {
            if(br != null) {
                br.close();
            }
        }
    }
}
