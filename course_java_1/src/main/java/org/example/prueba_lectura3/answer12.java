package org.example.prueba_lectura3;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class answer12 {
    public static void main(String[] args) {
        // Generar un DoubleStream con los números 0, 2 y 4
        DoubleStream stream = DoubleStream.of(0, 2, 4);

        // Filtrar solo números impares y sumar el resto
        double sum = stream
                .filter(n -> n % 2 != 0) // Filtrar impares
                .sum(); // Sumar los restantes

        System.out.println("Sum: " + sum); // Output: Sum: 0.0

        // Generar un Stream de Double con los números 1.0 y 3.0
        Stream<Double> stream2 = Stream.of(1.0, 3.0);

        // Mapear a primitivos, filtrar pares y calcular el promedio
        double average = stream2
                .mapToDouble(Double::doubleValue) // Mapear a primitivos double
                .filter(n -> n % 2 == 0) // Filtrar solo números pares
                .average() // Calcular el promedio
                .orElse(0.0); // Evitar excepción si el stream está vacío

        System.out.println("Average: " + average); // Output: Average: 0.0
    }
}
