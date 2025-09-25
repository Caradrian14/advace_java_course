package org.example.prueba_lecture18.assaigment;

final class AccountingDept2 extends Department2 {
    public void accounting() {
        System.out.println("Custom accounting");
    }

    @Override
    public String toString() {
        return "Accounting";
    }
}
