package org.example.prueba_lectura2;
import java.util.Optional;

public class answer10 {
    public static void main(String[] args) {
        // a. Declarar un Optional<Double> con un valor no nulo
        Optional<Double> price = Optional.ofNullable(20.0);

        // i. Usar ifPresent(Consumer)
        price.ifPresent(p -> System.out.println("ifPresent: " + p));

        // ii. Usar orElse(T)
        System.out.println("orElse: " + price.orElse(0.0));

        // iii. Usar orElseGet(Supplier)
        System.out.println("orElseGet: " + price.orElseGet(() -> 0.0));

        // b. Declarar un Optional<Double> con un valor nulo
        Optional<Double> price2 = Optional.ofNullable(null);

        // i. Imprimir el Optional directamente
        System.out.println("Optional: " + price2);

        // ii. Verificar si está vacío con isEmpty()
        if (price2.isEmpty()) {
            System.out.println("empty");
        }

        // iii. Usar ifPresent(Consumer) para verificar si está vacío
        price2.ifPresentOrElse(
                p -> System.out.println("Valor: " + p),
                () -> System.out.println("empty")
        );

        // iv. Usar orElse(T) para obtener un valor por defecto
        Double x = price2.orElse(44.0);
        System.out.println("Valor de x: " + x);

        // c. Declarar un Optional<Double> con un valor nulo
        Optional<Double> price3 = Optional.ofNullable(null);

        try {
            // i. Usar orElseThrow(Supplier) para lanzar una excepción si está vacío
            Double z = price3.orElseThrow(() -> new RuntimeException("Bad Code"));
            System.out.println("Valor de z: " + z);
        } catch (RuntimeException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}
