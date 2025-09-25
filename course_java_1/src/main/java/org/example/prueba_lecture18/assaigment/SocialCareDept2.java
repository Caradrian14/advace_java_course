package org.example.prueba_lecture18.assaigment;

final class SocialCareDept2 extends Department2 {
    public void socialCare() {
        System.out.println("Custom social care");
    }

    @Override
    public String toString() {
        return "Social Care";
    }
}
