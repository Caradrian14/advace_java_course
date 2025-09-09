package org.example.prueba_lectura2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class answer7 {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Atlas Shrugged", 10.0),
                new Book("Freedom at Midnight", 5.0),
                new Book("Gone with the wind", 5.0)
        );

        // Stream the books and create a map: title -> price
        Map<String, Double> bookMap = books.stream()
                .collect(Collectors.toMap(
                        Book::getTitle,  // Key: book title
                        Book::getPrice   // Value: book price
                ));

        // Iterate through the map and output prices for titles starting with "A"
        bookMap.forEach((title, price) -> {
            if (title.startsWith("A")) {
                System.out.println(price);
            }
        });
    }
}
