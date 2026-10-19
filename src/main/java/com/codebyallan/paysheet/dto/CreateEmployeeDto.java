package com.codebyallan.paysheet.dto;

import com.codebyallan.paysheet.enums.EmployeeType;

public record CreateEmployeeDto(int registration, String name, EmployeeType type, Double sellingValue,
                                Integer commissionPercentage, Integer partsQtd, Double partsValue) {
}
