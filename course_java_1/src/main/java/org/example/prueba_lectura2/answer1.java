package org.example.prueba_lectura2;
import java.util.stream.IntStream;


//public class respuestas_1 { }

public class answer1 {
    public static void main(String[] args) {
        double average = IntStream.range(0, 5)
                .average()
                .orElse(Double.NaN);
        System.out.println("The average is: " + average);
    }
}