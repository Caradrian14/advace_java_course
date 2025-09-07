package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.BiPredicate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.Function;

public class LambdasAndMethodReferences {
    public static void main(String[] args) {

    }

    public static void staticMR() {
        // a
        List<Integer> numbers = Arrays.asList(1, 2, 7, 4, 5);
        System.out.println("Lista inicial: " + numbers);

        // b
        Consumer<List<Integer>> sortLambda = list -> Collections.sort(list);

        // c
        sortLambda.accept(numbers);
        System.out.println("ordered list with lambda: " + numbers);

        // d
        System.out.println("Its ordered? " + isSorted(numbers));

        // e
        numbers = Arrays.asList(1, 2, 7, 4, 5);
        System.out.println("list re-initizalize: " + numbers);

        // f
        Consumer<List<Integer>> sortMethodRef = Collections::sort;

        // g
        sortMethodRef.accept(numbers);
        System.out.println("ordered list with method reference: " + numbers);

        // h
        System.out.println("¿Está ordenada? " + isSorted(numbers));
    }

    public static void boundMR() {
        // a
        String name = "Mr. Joe Bloggs";
        System.out.println("Name: " + name);

        // b
        Predicate<String> startsWithLambda = prefix -> name.startsWith(prefix);

        // c
        boolean resultLambdaMr = startsWithLambda.test("Mr.");
        System.out.println("Lambda - Starts with 'Mr.'? " + resultLambdaMr); // true

        // d
        boolean resultLambdaMs = startsWithLambda.test("Ms.");
        System.out.println("Lambda - Starts with 'Ms.'? " + resultLambdaMs); // false

        // e
        Predicate<String> startsWithMethodRef = name::startsWith;

        // f
        boolean resultMethodRefMr = startsWithMethodRef.test("Mr.");
        System.out.println("Method Reference - Starts with 'Mr.'? " + resultMethodRefMr); // true

        boolean resultMethodRefMs = startsWithMethodRef.test("Ms.");
        System.out.println("Method Reference - Starts with 'Ms.'? " + resultMethodRefMs); // false
    }

    public static void unboundMR() {
        // a
        Predicate<String> isEmptyLambda = str -> str.isEmpty();

        // b
        boolean resultEmpty = isEmptyLambda.test("");
        System.out.println("Lambda - Is empty string? " + resultEmpty); // Expected: true

        // c
        boolean resultNonEmpty = isEmptyLambda.test("xyz");
        System.out.println("Lambda - Is 'xyz' empty? " + resultNonEmpty); // Expected: false

        // d
        Predicate<String> isEmptyMethodRef = String::isEmpty;

        // e
        boolean resultEmptyMethodRef = isEmptyMethodRef.test("");
        System.out.println("Method Reference - Is empty string? " + resultEmptyMethodRef); // Expected: true

        boolean resultNonEmptyMethodRef = isEmptyMethodRef.test("xyz");
        System.out.println("Method Reference - Is 'xyz' empty? " + resultNonEmptyMethodRef); // Expected: false

        // f
        BiPredicate<String, String> startsWithLambda = (str, prefix) -> str.startsWith(prefix);

        boolean resultStartsWithMr = startsWithLambda.test("Mr. Joe Bloggs", "Mr.");
        System.out.println("Lambda - Does 'Mr. Joe Bloggs' start with 'Mr.'? " + resultStartsWithMr); // Expected: true

        boolean resultStartsWithMs = startsWithLambda.test("Mr. Joe Bloggs", "Ms.");
        System.out.println("Lambda - Does 'Mr. Joe Bloggs' start with 'Ms.'? " + resultStartsWithMs); // Expected: false

        // g
        BiPredicate<String, String> startsWithMethodRef = String::startsWith;

        // h
        boolean resultStartsWithMrMethodRef = startsWithMethodRef.test("Mr. Joe Bloggs", "Mr.");
        System.out.println("Method Reference - Does 'Mr. Joe Bloggs' start with 'Mr.'? " + resultStartsWithMrMethodRef); // Expected: true

        boolean resultStartsWithMsMethodRef = startsWithMethodRef.test("Mr. Joe Bloggs", "Ms.");
        System.out.println("Method Reference - Does 'Mr. Joe Bloggs' start with 'Ms.'? " + resultStartsWithMsMethodRef); // Expected: false
    }

    public static void constructorMR() {
        // a
        Supplier<List<String>> arrayListSupplierLambda = () -> new ArrayList<>();

        // b
        List<String> list = arrayListSupplierLambda.get();

        // c
        list.add("Lambda");

        // d
        System.out.println("Lambda - List contents: " + list); // Expected: [Lambda]

        // e
        Supplier<List<String>> arrayListSupplierMethodRef = ArrayList::new;

        list = arrayListSupplierMethodRef.get();

        list.add("Method Reference");

        System.out.println("Method Reference - List contents: " + list); // Expected: [Method Reference]
        // f
        Function<Integer, List<String>> arrayListFunctionLambda = capacity -> new ArrayList<>(capacity);

        list = arrayListFunctionLambda.apply(10);

        list.add("Lambda");

        System.out.println("Lambda (with capacity) - List contents: " + list); // Expected: [Lambda]

        // g
        Function<Integer, List<String>> arrayListFunctionMethodRef = ArrayList::new;

        // g.1
        list = arrayListFunctionMethodRef.apply(10);

        // g.2
        list.add("Method Reference");

        // g.3
        System.out.println("Method Reference (with capacity) - List contents: " + list); // Expected: [Method Reference]
    }

    //auxulai methon to check
    private static boolean isSorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}