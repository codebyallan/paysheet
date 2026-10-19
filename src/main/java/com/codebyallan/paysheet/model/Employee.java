package com.codebyallan.paysheet.model;

import com.codebyallan.paysheet.enums.EmployeeType;

public class Employee {
    protected final int registration;
    protected final String name;
    protected final EmployeeType type;
    protected static final double salary = 2000;

    protected Employee(int registration, String name, EmployeeType type) {
        this.registration = registration;
        this.name = name;
        this.type = type;
    }

    public double salaryCalc() {
        return salary;
    }

    public void getDetails() {
        System.out.printf("Matrícula: %d%nNome: %s%nSalário Base: R$ %.2f%n", this.registration, this.name, salary);
    }
}