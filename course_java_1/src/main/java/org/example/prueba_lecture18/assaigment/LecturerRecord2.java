package org.example.prueba_lecture18.assaigment;
import java.util.Objects;

public final record LecturerRecord2(String name, Integer age, Faculty2 faculty, Department2 dept) {
    public LecturerRecord2 {
        if (name.isBlank() || age < 0) {
            String errorMessage = """
                    Invalid lecturer details:
                    - Name: "%s"
                    - Age: %d
                    """.formatted(name, age);
            throw new IllegalArgumentException(errorMessage);
        }
    }
    // Método hasPhd()
    public boolean hasPhd() {
        String prefix = name.length() >= 3 ? name.substring(0, 3) : "";
        String suffix = name.length() >= 3 ? name.substring(name.length() - 3) : "";
        return switch (prefix) {
            case "Dr." -> true;
            default -> switch (suffix) {
                case "PhD" -> true;
                default -> false;
            };
        };
    }

    // Método whichFaculty()
    public void whichFaculty() {
        switch (faculty) {
            case EngineeringFaculty eng -> {
                System.out.println("Faculty of: " + eng);
                eng.engineering();
            }
            case HumanitiesFaculty hum -> {
                System.out.println("Faculty of: " + hum);
                hum.humanities();
            }
            case BusinessFaculty bus -> {
                System.out.println("Faculty of: " + bus);
                bus.business();
            }
            default -> throw new IllegalArgumentException("Unknown faculty: " + faculty);
        }
    }

    // Método whichDept()
    public void whichDept() {
        switch (dept) {
            case ComputerEngineeringDept2 compEng -> {
                System.out.println("Dept of: " + compEng);
                compEng.compEng();
            }
            case SoftwareEngineeringDept2 swEng -> {
                System.out.println("Dept of: " + swEng);
                swEng.swEng();
            }
            case SocialCareDept2 socialCare -> {
                System.out.println("Dept of: " + socialCare);
                socialCare.socialCare();
            }
            case AccountingDept2 accounting -> {
                System.out.println("Dept of: " + accounting);
                accounting.accounting();
            }
            default -> throw new IllegalArgumentException("Unknown department: " + dept);
        }
    }
}
