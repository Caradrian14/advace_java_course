package org.example.prueba_lectura2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class answear3 {
    public static void main(String[] args) {
        Stream<List<String>> listStream = Stream.of(
                Arrays.asList("a", "b"),
                Arrays.asList("a", "c")
        );
        // Filter, flatten, and output
        listStream
                .filter(list -> list.contains("c"))
                .flatMap(List::stream)
                .forEach(System.out::print);
    }
}
