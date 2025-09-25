package org.example.prueba_lecture18.assaigment;

// Educational.java (interfaz marker, sellada y package-private)
sealed interface Educational2 permits Faculty2 {
    // Interfaz marker: no contiene métodos
}

// Faculty.java
public abstract sealed class Faculty2 implements Educational2 permits EngineeringFaculty, HumanitiesFaculty, BusinessFaculty {
    // Método abstracto para que lo implementen los subtipos
    @Override
    public abstract String toString();
}

// Subtipos package-private y finales
final class EngineeringFaculty extends Faculty2 {
    public void engineering() {
        System.out.println("We teach computer science, civil engineering etc...");
    }

    @Override
    public String toString() {
        return "Engineering";
    }
}

final class HumanitiesFaculty extends Faculty2 {
    public void humanities() {
        System.out.println("We teach social care, European studies etc...");
    }

    @Override
    public String toString() {
        return "Humanities";
    }
}

final class BusinessFaculty extends Faculty2 {
    public void business() {
        System.out.println("We teach accountancy, law, economics etc...");
    }

    @Override
    public String toString() {
        return "Business";
    }
}
