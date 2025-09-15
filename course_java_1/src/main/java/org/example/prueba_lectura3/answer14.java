package org.example.prueba_lectura3;

public class answer14 {
//    Stream.parallel(): El stream se procesa en paralelo, lo que significa que el orden de ejecución no está garantizado y las operaciones pueden ocurrir en cualquier orden.
//    filter(): Solo los elementos que cumplen la condición n % 2 == 0 pasan al siguiente paso. Sin embargo, el incrementAndGet() se ejecuta para cada elemento del stream, independientemente de si cumple la condición o no.
//    Problema: Aunque se llama a incrementAndGet() para cada elemento (4 veces), el resultado del filter() no se consume. En Java, las operaciones intermedias (como filter()) son perezosas y no se ejecutan hasta que se invoca una operación terminal (como count(), forEach(), etc.). Como no hay operación terminal, el stream no se procesa y ai sigue siendo 0.

    public static void main(String[] args) {
//        AtomicInteger ai = new AtomicInteger(); // Valor inicial 0
//        Stream.of(11, 11, 22, 33)
//                .parallel()
//                .filter(n -> {
//                    ai.incrementAndGet();
//                    return n % 2 == 0;
//                })
//                .count(); // Operación terminal para forzar el procesamiento
//        System.out.println(ai); // Ahora imprime 4

//        IllegalStateException: Ocurre porque un stream solo puede ser consumido una vez. En el código, el stream se consume primero en el filter() (aunque no tiene operación terminal), y luego se intenta consumir nuevamente con forEach(). Esto no es permitido en Java.
    }

}
