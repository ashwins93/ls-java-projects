package io.github.ashwins93.stringsort;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        var actualNames = new String[]{
                "Johnson", "Wilson",
                "Wilkinson", "Abraham", "Dagobert"
        };
        Sort.sort(actualNames);

        for(final String name: actualNames) {
            System.out.println(name);
        }
    }
}
