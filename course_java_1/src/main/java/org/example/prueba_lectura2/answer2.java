package org.example.prueba_lectura2;

import java.util.Arrays;
import java.util.List;

public class answer2 {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(1, "Screw"),
                new Item(2, "Nail"),
                new Item(3, "Bolt")
        );

        // Stream, sort, and print
        items.stream()
                .sorted((item1, item2) -> item1.getName().compareTo(item2.getName()))
                .forEach(System.out::print);
    }
}