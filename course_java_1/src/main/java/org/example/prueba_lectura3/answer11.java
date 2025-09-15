package org.example.prueba_lectura3;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class answer11 {
    public static void main(String[] args) {
        // Declarar la lista de libros
        List<AnotherBook> books = List.of(
                new AnotherBook("Gone with the wind", "Fiction"),
                new AnotherBook("Bourne Ultimatum", "Thriller"),
                new AnotherBook("The Client", "Thriller")
        );

        // Declarar la lista de géneros
        List<String> genreList = new ArrayList<>();

        // Usar stream para extraer los géneros y asignarlos a genreList
        genreList = books.stream()
                .map(AnotherBook::getGenre) // Extrae el género de cada libro
                .collect(Collectors.toList()); // Convierte el stream a una lista

        // Imprimir el resultado
        System.out.println(genreList); // Output: [Fiction, Thriller, Thriller]
    }
}
