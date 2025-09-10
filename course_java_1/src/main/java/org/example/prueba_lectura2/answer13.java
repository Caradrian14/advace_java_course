package org.example.prueba_lectura2;

import java.util.Arrays;
import java.util.List;

public class answer13 {
    public static void main(String[] args) {
        // Declarar la lista de enteros
        List<Integer> ls = Arrays.asList(11, 11, 22, 33, 33, 55, 66);

        // Parte a: Stream con elementos únicos y verificar si alguno es 11
        boolean anyMatchResult = ls.stream()
                .distinct() // Solo elementos únicos
                .anyMatch(x -> x == 11); // ¿Alguno es 11?

        System.out.println("anyMatch(11): " + anyMatchResult); // Output: true

        // Parte b: Stream nuevamente y verificar si ninguno cumple x%11>0
        boolean noneMatchResult = ls.stream()
                .noneMatch(x -> x % 11 > 0); // ¿Ninguno cumple x%11>0?

        System.out.println("noneMatch(x%11>0): " + noneMatchResult); // Output: true
    }
}
