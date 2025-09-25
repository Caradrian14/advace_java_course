package org.example.prueba_lecture18.assaigment;

public abstract sealed class Department2 permits ComputerEngineeringDept2, SoftwareEngineeringDept2, SocialCareDept2, AccountingDept2 {
    // Abstract method to be overridden by all subtypes
    public abstract String toString();
}
