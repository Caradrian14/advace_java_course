package org.example.prueba_lectura2;
import java.util.Arrays;
import java.util.List;

public class answer6 {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Thinking in Java", 30.0),
                new Book("Java in 24 hrs", 20.0),
                new Book("Java Recipes", 10.0)
        );

        double averagePrice = books.stream()
                .filter(book -> book.getPrice() > 10)
                .mapToDouble(Book::getPrice)
                .average()
                .orElse(0.0);

        System.out.println("Average price (price > 10): " + averagePrice);
    }
}
