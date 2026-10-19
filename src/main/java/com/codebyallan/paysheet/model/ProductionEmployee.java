package com.codebyallan.paysheet.model;

import com.codebyallan.paysheet.enums.EmployeeType;

public final class ProductionEmployee extends Employee {
    private final int partsQtd;
    private final double partsValue;

    private ProductionEmployee(int registration, String name, int partsQtd, double partsValue) {
        super(registration, name, EmployeeType.PRODUCTION);
        this.partsQtd = partsQtd;
        this.partsValue = partsValue;
    }

    public static ProductionEmployee create(int registration, String name, int partsQtd, double partsValue) {
        return new ProductionEmployee(registration, name, partsQtd, partsValue);
    }

    private double productivity() {
        return partsQtd * partsValue;
    }

    @Override
    public double salaryCalc() {
        return salary + productivity();
    }

    @Override
    public void getDetails() {
        System.out.printf("Matrícula: %d%nNome: %s%nSalário Base: R$ %.2f%nProdutividade: R$ %.2f%nSalário Final: R$ %.2f%nTipo: Produção%n", this.registration, this.name, salary, productivity(), salaryCalc());
    }
}