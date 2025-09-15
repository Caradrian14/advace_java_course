package org.example.prueba_lectura3;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Comparator;
import java.util.Optional;


public class answer4 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        //a.1
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum: " + sum); // Sum: 6

        //a.2
        OptionalInt max = numbers.stream()
                .mapToInt(Integer::intValue)
                .max();
        System.out.println("Max: " + max.orElse(Integer.MIN_VALUE)); //Max: 3


        List<Person> people = Arrays.asList(
            new Person("Alan", "Burke", 22),
            new Person("Zoe", "Peters", 20),
            new Person("Peter", "Castle", 29)
        );
        //b
        Person oldest = people.stream()
                .max(Comparator.comparingInt(Person::getAge))
                .orElse(null);
        System.out.println("Oldest: " + oldest.getFirstName() + " " + oldest.getLastName()); //Output: Oldest: Peter Castle

        List<Integer> numbers2 = Arrays.asList(10, 47, 33, 23);

        // c.1
        Optional<Integer> max2 = numbers2.stream()
                .reduce((a, b) -> Math.max(a, b));
        System.out.println("Max (Optional): " + max2.orElse(Integer.MIN_VALUE));
        //c.2
        int max3 = numbers.stream()
                .reduce(Integer.MIN_VALUE, (a, b) -> Math.max(a, b));
        System.out.println("Max (Identity): " + max3); // Output: Max (Identity): 47
    }
}
