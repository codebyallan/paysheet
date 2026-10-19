package com.codebyallan.paysheet.model;

import com.codebyallan.paysheet.enums.EmployeeType;

public final class CommissionEmployee extends Employee {
    private final double sellingValue;
    private final int commissionPercentage;

    private CommissionEmployee(int matricula, String name, double sellingValue, int commissionPercentage) {
        super(matricula, name, EmployeeType.COMMISSION);
        this.sellingValue = sellingValue;
        this.commissionPercentage = commissionPercentage;
    }

    public static CommissionEmployee create(int registration, String name, double sellingValue, int commissionPercentage) {
        return new CommissionEmployee(registration, name, sellingValue, commissionPercentage);
    }

    private double commissionCalc() {
        return sellingValue * commissionPercentage / 100;
    }

    @Override
    public double salaryCalc() {
        return salary + commissionCalc();
    }

    @Override
    public void getDetails() {
        System.out.printf("Matrícula: %d%nNome: %s%nSalário Base: R$ %.2f%nValor das Vendas: R$ %.2f%nComissão: %d%%%nSalário Final: R$ %.2f%nTipo: Comissionado%n", this.registration, this.name, salary, this.sellingValue, this.commissionPercentage, salaryCalc());
    }
}