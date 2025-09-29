package org.example.prueba_lecture18.assaigment;

public class University2 {
    void main(String[] args) {
        // 1. Forzar excepciones
        try {
            LecturerRecord2 lecturer1 = new LecturerRecord2("", -5, new EngineeringFaculty(), new SoftwareEngineeringDept2());
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        try {
            LecturerRecord2 lecturer2 = new LecturerRecord2("   ", 25, new EngineeringFaculty(), new SoftwareEngineeringDept2());
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // 2. Crear un LecturerRecord para Jane Bloggs
        LecturerRecord2 jane = new LecturerRecord2("Jane Bloggs", 24, new EngineeringFaculty(), new SoftwareEngineeringDept2());
        System.out.println("\nJane's details (toString): " + jane);

        // 3. Imprimir detalles de Jane usando los métodos de acceso
        System.out.println("\nJane's details (accessors):");
        System.out.println("Name: " + jane.name());
        System.out.println("Age: " + jane.age());
        System.out.println("Faculty: " + jane.faculty());
        System.out.println("Department: " + jane.dept());

        // 4. Invocar whichFaculty() para Jane
        System.out.println("\nJane's faculty details:");
        jane.whichFaculty();

        // 5. Invocar whichDept() para Jane
        System.out.println("\nJane's department details:");
        jane.whichDept();

        // 6. ¿Jane tiene un PhD?
        System.out.println("\nDoes Jane have a PhD? " + (jane.hasPhd() ? "Yes" : "No"));

        // 7. Crear un registro para Dr. Anne Bloggs
        LecturerRecord2 anne = new LecturerRecord2("Dr. Anne Bloggs", 35, new BusinessFaculty(), new AccountingDept2());
        System.out.println("\nAnne's details (toString): " + anne);
        System.out.println("Does Anne have a PhD? " + (anne.hasPhd() ? "Anne has a PhD" : "Anne has not a PhD"));

        // 8. Crear un registro para Joe Bloggs PhD
        LecturerRecord2 joe = new LecturerRecord2("Joe Bloggs PhD", 54, new HumanitiesFaculty(), new SocialCareDept2());
        System.out.println("\nJoe's details (toString): " + joe);
        System.out.println("Does Joe have a PhD? " + (joe.hasPhd() ? "Joe has a PhD" : "Joe has not a PhD"));
    }
}
