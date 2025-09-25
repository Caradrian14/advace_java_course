package org.example.prueba_lecture18.assaigment;

final class SocialCareDept extends Department {
    public void socialCare() {
        System.out.println("Custom social care");
    }

    @Override
    public String toString() {
        return "Social Care";
    }
}
