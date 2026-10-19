package com.codebyallan.paysheet.repository;

import com.codebyallan.paysheet.model.Employee;

import java.util.List;

public class EmployeeRepository {
    private final List<Employee> employees;

    public EmployeeRepository(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee save(Employee employee) {
        if (employee == null) {
            return null;
        }
        employees.add(employee);
        return employee;
    }

    public List<Employee> getEmployees() {
        return List.copyOf(this.employees);
    }
}
