package org.example.prueba_lecture18.assaigment;

// Package-private final subtypes
final class ComputerEngineeringDept2 extends Department2 {
    public void compEng() {
        System.out.println("Custom computer engineering");
    }

    @Override
    public String toString() {
        return "Computer Engineering";
    }
}
