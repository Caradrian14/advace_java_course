package org.example;

import java.util.ArrayList;
import java.util.List;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import java.util.Comparator;


public class exam1 {
    @FunctionalInterface
    interface Printable {
        void print(String s);
    }

    @FunctionalInterface
    interface Retrievable<T> {
        T retrieve();
    }

    @FunctionalInterface
    interface Functionable<T, R> {
        R apply(T t);
    }

    public static void main(String[] args) {
        FI_from_API fiAPI = new FI_from_API();
        fiAPI.consumer();

        // 1a
        Printable printableLambda = s -> System.out.println(s);
        printableLambda.print("Printable lambda");

        // 1b_1
        Consumer<String> consumerLambda = s -> System.out.println(s);
        consumerLambda.accept("Printable lambda 1b_1");

        // 1b_2
        Consumer<String> consumerMethodRef = System.out::println;
        consumerMethodRef.accept("Printable lambda 1b_2");

        // 2
        supplier();

        // 3
        predicate();
        Person mike = new Person("Mike", 33, 1.8);
        Person ann = new Person("Ann", 13, 1.4);

        //check()
        System.out.println("Is 4 even? " + check(4, n -> n % 2 == 0)); // true
        System.out.println("Is 7 even? " + check(7, n -> n % 2 == 0)); // false

        System.out.println("Does 'Mr. Joe Bloggs' start with 'Mr.'? " +
                check("Mr. Joe Bloggs", s -> s.startsWith("Mr."))); // true
        System.out.println("Does 'Ms. Ann Bloggs' start with 'Mr.'? " +
                check("Ms. Ann Bloggs", s -> s.startsWith("Mr."))); // false

        System.out.println("Is Mike an adult? " +
                check(mike, p -> p.age >= 18)); // true
        System.out.println("Is Ann an adult? " +
                check(ann, p -> p.age >= 18)); // false
        // 4a 4b
        function();

        // 5
        List<Person> listPeople = getPeople();

        // 6
        sortAge(listPeople);
        listPeople.forEach(person -> System.out.println(person.name + " - " + person.age));

        // 7
        sortName(listPeople);

        // 8
        sortHeight(listPeople);

        // 9
        sortAgeMR(listPeople);
        sortNameMR(listPeople);
        sortHeightMR(listPeople);
    }

    public static void consumer() {
        // a)
        Printable printableLambda = s -> System.out.println(s);
        printableLambda.print("Printable lambda");

        // b)lambda
        Consumer<String> consumerLambda = s -> System.out.println(s);
        consumerLambda.accept("Consumer lambda");

        // b) method reference
        Consumer<String> consumerMethodRef = System.out::println;
        consumerMethodRef.accept("Consumer method reference");
    }

    public static void supplier() {
        // 2a
        Retrievable<Integer> retrievableLambda = () -> 77;
        int result = retrievableLambda.retrieve();
        System.out.println("Retrievable: " + result);

        // 2b
        Supplier<Integer> supplierLambda = () -> 77;
        int resultB = supplierLambda.get();
        System.out.println("Supplier: " + resultB);
    }

    public static void predicate() {
        // 3a Evaluate
        Evaluate<Integer> evaluateLambda = i -> i < 0;
        System.out.println("Evaluate (-1): " + evaluateLambda.isNegative(-1)); // true
        System.out.println("Evaluate (+1): " + evaluateLambda.isNegative(+1)); // false

        // 3b Predicate
        Predicate<Integer> predicateLambda = i -> i < 0;
        System.out.println("Predicate (-1): " + predicateLambda.test(-1)); // true
        System.out.println("Predicate (+1): " + predicateLambda.test(+1)); // false

        // c) Generically-typed check() method
        System.out.println("Is 4 even? " + check(4, n -> n % 2 == 0)); // true
        System.out.println("Is 7 even? " + check(7, n -> n % 2 == 0)); // false

        System.out.println("Does 'Mr. Joe Bloggs' start with 'Mr.'? " +
                check("Mr. Joe Bloggs", s -> s.startsWith("Mr."))); // true
        System.out.println("Does 'Ms. Ann Bloggs' start with 'Mr.'? " +
                check("Ms. Ann Bloggs", s -> s.startsWith("Mr."))); // false

        class Person {
            String name;
            int age;
            double height;

            Person(String name, int age, double height) {
                this.name = name;
                this.age = age;
                this.height = height;
            }
        }

        Person mike = new Person("Mike", 33, 1.8);
        Person ann = new Person("Ann", 13, 1.4);

        System.out.println("Is Mike an adult? " +
                check(mike, p -> p.age >= 18)); // true
        System.out.println("Is Ann an adult? " +
                check(ann, p -> p.age >= 18)); // false
    }

    static class Person {
        String name;
        int age;
        double height;

        Person(String name, int age, double height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        private static void printPersonInfo(Person person) {
            System.out.println(person.name + " - " + person.age + " years old");
        }

        public int getAge() {
            return this.age;
        }

        public void printNameAndAge() {
            System.out.println(this.name + " - " + this.age + " years old");
        }

        public void printNameAndHeight() {
            System.out.println(this.name + " - " + this.height + " meters tall");
        }
    }

    private static void sortAge(List<Person> people) {
        // a
            people.sort(Comparator.comparing(person -> person.age));

        // b
        people.forEach(person ->
                System.out.println(person.name + " - " + person.age + " years old"));
    }

    private static void sortAgeMR(List<Person> people) {
        // 9a
        people.sort(Comparator.comparing(Person::getAge));
    }

    //check()
    public static <T> boolean check(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }

    public static void function() {
        // 4a
        Functionable<Integer, String> functionableLambda = num -> "Number is: " + num;
        String result = functionableLambda.apply(25);
        System.out.println(result); // "Number is: 25"

        // 4b
        Function<Integer, String> functionLambda = num -> "Number is: " + num;
        String resultB = functionLambda.apply(25);
        System.out.println(resultB); // "Number is: 25"
    }

    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }

    private static void sortName(List<Person> people) {
        // a Comparator.comparing()
        people.sort(Comparator.comparing(person -> person.name));

        // b forEach() lambda
        people.forEach(person ->
                System.out.println(person.name + " - " + person.age + " years old"));
    }

    private static void sortNameMR(List<Person> people) {
        // 9b
        people.forEach(Person::printNameAndAge);
    }

    private static void sortHeight(List<Person> people) {
        // a) Comparator.comparing()
        people.sort(Comparator.comparing(person -> person.height));

        // b) forEach() lambda
        people.forEach(person ->
                System.out.println(person.name + " - " + person.height + " meters tall"));
    }

    private static void sortHeightMR(List<Person> people) {
        // b)
        people.forEach(person ->
                System.out.println(person.name + " - " + person.height + " meters tall"));
    }
}
