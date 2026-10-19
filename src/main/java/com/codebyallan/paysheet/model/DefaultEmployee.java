package com.codebyallan.paysheet.model;

import com.codebyallan.paysheet.enums.EmployeeType;

public final class DefaultEmployee extends Employee {
    private DefaultEmployee(int registration, String name) {
        super(registration, name, EmployeeType.DEFAULT);
    }

    public static DefaultEmployee create(int registration, String name) {
        return new DefaultEmployee(registration, name);
    }

    @Override
    public void getDetails() {
        System.out.printf("Matrícula: %d%nNome: %s%nSalário Base: R$ %.2f%nSalário Final: R$ %.2f%nTipo: Padrão%n", this.registration, this.name, salary, salaryCalc());
    }
}