package org.example.prueba_lectura2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class answer8 {
    List<Book> books = Arrays.asList(
            new Book("Gone with the wind", 5.0),
            new Book("Gone with the wind", 10.0),
            new Book("Atlas shrugged", 15.0)
    );
    Map<String, Double> bookMap = books.stream()
            .collect(Collectors.toMap(
                    Book::getTitle,
                    Book::getPrice
            ));
//bookMap.forEach((title, price) ->
 //           System.out.println(title + ": " + price)
  //          );
//This code will throw an IllegalStateException because there are duplicate keys ("Gone with the wind" appears twice).
 //           Collectors.toMap() does not allow duplicate keys by default.

    //sollution
public static void main(String[] args) {
    List<Book> books = Arrays.asList(
            new Book("Gone with the wind", 5.0),
            new Book("Gone with the wind", 10.0),
            new Book("Atlas shrugged", 15.0)
    );

    Map<String, Double> bookMap = books.stream()
            .collect(Collectors.toMap(
                    Book::getTitle,  // key
                    Book::getPrice,  // value
                    (oldPrice, newPrice) -> newPrice  // Resolve duplicates: keep the new price
            ));

    // Output each entry in the map
    bookMap.forEach((title, price) ->
            System.out.println(title + ": " + price)
    );
}
}
