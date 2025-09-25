package org.example.prueba_lecture18.assaigment;

public abstract sealed class Department permits ComputerEngineeringDept, SoftwareEngineeringDept, SocialCareDept, AccountingDept {
    // Abstract method to be overridden by all subtypes
    public abstract String toString();
}
