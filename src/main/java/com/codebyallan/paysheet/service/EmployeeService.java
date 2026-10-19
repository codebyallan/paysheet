package com.codebyallan.paysheet.service;

import com.codebyallan.paysheet.dto.CreateEmployeeDto;
import com.codebyallan.paysheet.model.CommissionEmployee;
import com.codebyallan.paysheet.model.DefaultEmployee;
import com.codebyallan.paysheet.model.Employee;
import com.codebyallan.paysheet.model.ProductionEmployee;
import com.codebyallan.paysheet.repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void createEmployee(CreateEmployeeDto createEmployeeDto) {
        if (createEmployeeDto == null) {
            throw new IllegalArgumentException();
        }
        int registration = createEmployeeDto.registration();
        String name = createEmployeeDto.name();

        var newEmployee = switch (createEmployeeDto.type()) {
            case DEFAULT -> DefaultEmployee.create(registration, name);
            case COMMISSION ->
                    CommissionEmployee.create(registration, name, createEmployeeDto.sellingValue(), createEmployeeDto.commissionPercentage());
            case PRODUCTION ->
                    ProductionEmployee.create(registration, name, createEmployeeDto.partsQtd(), createEmployeeDto.partsValue());
        };
        employeeRepository.save(newEmployee);

    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.getEmployees();
    }

    public void generatePaySheet() {
        var employees = findAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado ainda.\n");
            return;
        }
        System.out.println("Folha de pagamento:");
        for (Employee employee : employees) {
            System.out.println("-----------");
            employee.getDetails();
            System.out.println();
        }
    }

    public void generateResumePaySheet() {
        var employees = findAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado ainda.\n");
            return;
        }
        int employeeCount = employees.size();
        double totalPaySheet = 0.0;
        double mediumPaySheet;
        for (Employee employee : employees) {
            totalPaySheet += employee.salaryCalc();
        }
        mediumPaySheet = totalPaySheet / employeeCount;
        System.out.println("Resumo da Folha de Pagamento:");
        System.out.printf("Total de Funcionários: %d%n", employeeCount);
        System.out.printf("Total da Folha de Pagamento: R$ %.2f%n", totalPaySheet);
        System.out.printf("Média Salarial: R$ %.2f%n", mediumPaySheet);
    }

}
