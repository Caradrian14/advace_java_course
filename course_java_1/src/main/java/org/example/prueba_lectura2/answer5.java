package org.example.prueba_lectura2;
import java.util.Optional;

public class answer5 {
    public static Optional<String> getGrade(int marks) {
        // a.1
        Optional<String> grade = Optional.empty();

        // a.2
        if (marks > 50) {
            grade = Optional.of("PASS");
        } else {
            grade = Optional.of("FAIL");
        }
        return grade;
    }

    public static void main(String[] args) {
        //1
        Optional<String> grade1 = getGrade(50);

        //2
        Optional<String> grade2 = getGrade(55);

        //3
        System.out.println(grade1.orElse("UNKNOWN")); // Output: FAIL

        // 4
        if (grade2.isPresent()) {
            grade2.ifPresent(System.out::println); // Output: PASS
        } else {
            System.out.println(grade2.orElse("Empty"));
        }
    }
}
