package org.example.prueba_lectura2;

import java.util.Arrays;
import java.util.List;

public class answer9 {
    public static void main(String[] args) {
        // Definición de la clase Person (asumida)
        class Person {
            private String name;
            private String lastName; // Añadido para coincidir con el constructor
            private int age;

            public Person(String name, String lastName, int age) {
                this.name = name;
                this.lastName = lastName;
                this.age = age;
            }

            public int getAge() {
                return age;
            }
        }

        // Lista de personas
        List<Person> people = Arrays.asList(
                new Person("Bob", "", 31),
                new Person("Paul", "", 32),
                new Person("John", "", 33)
        );

        // Cálculo incorrecto (lanzará NoSuchElementException)
        try {
            double averageAgeWrong = people.stream()
                    .filter(person -> person.getAge() < 30)
                    .mapToInt(Person::getAge)
                    .average()
                    .getAsDouble(); // Lanzará NoSuchElementException
        } catch (Exception e) {
            System.out.println("Error esperado: " + e.getMessage());
        }

        // Cálculo correcto (usando orElse)
        double averageAge = people.stream()
                .filter(person -> person.getAge() < 30)
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0); // Retorna 0.0 si el stream está vacío

        String response = "Average age: " + averageAge;
        System.out.println(response); // Output: Average age: 0.0
    }
}
