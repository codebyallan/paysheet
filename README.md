# Payroll Management System

This project is a Java console application developed as an assessment for Curricular Unit the
**Algorithms and Programming Logic**. It simulates a simple payroll
system and demonstrates fundamental programming concepts such as object
orientation, inheritance, polymorphism, enumerations, records, collections,
input validation, and basic business logic.

## Project Overview

The application allows users to register employees, calculate their salaries,
generate a detailed payroll, and display a payroll summary. All information is
kept in memory while the application is running; no external database is
required.

The base salary is currently defined as **R$ 2,000.00** for every employee.
Additional compensation depends on the employee's type.

## Features

Through the interactive console menu, users can:

1. Create an employee.
2. Generate a detailed payroll.
3. Display a payroll summary.
9. Exit the application.

The application also checks whether numeric input is valid and displays an
error message when the user enters an invalid value.

## Employee Types

### Default employee

A default employee receives only the base salary:

```text
Final salary = base salary
```

### Commission employee

A commission employee receives the base salary plus a percentage of their sales:

```text
Commission = sales value × commission percentage / 100
Final salary = base salary + commission
```

### Production employee

A production employee receives the base salary plus payment for the parts
produced:

```text
Productivity = number of parts × value per part
Final salary = base salary + productivity
```

## Payroll Summary

The summary includes:

- Total number of registered employees.
- Total payroll amount.
- Average salary.

If no employees have been registered, the application informs the user instead
of generating an empty payroll.

## Technologies and Concepts

- Java
- Maven
- Console-based interaction with `Scanner`
- Object-oriented programming
- Inheritance and method overriding
- Polymorphism through the `Employee` base class
- `enum` for employee types
- Java `record` for the employee creation data transfer object
- `List` and in-memory data storage
- Separation of responsibilities between model, service, repository, and DTO

## Project Structure

```text
src/
├── main/
│   └── java/
│       ├── Main.java
│       └── com/codebyallan/paysheet/
│           ├── dto/
│           │   └── CreateEmployeeDto.java
│           ├── enums/
│           │   └── EmployeeType.java
│           ├── model/
│           │   ├── Employee.java
│           │   ├── DefaultEmployee.java
│           │   ├── CommissionEmployee.java
│           │   └── ProductionEmployee.java
│           ├── repository/
│           │   └── EmployeeRepository.java
│           └── service/
│               └── EmployeeService.java
└── test/
    └── java/
```

### Main components

- **`Main`**: starts the application and manages the console menu.
- **`Employee`**: defines the common attributes and salary behavior.
- **Employee subclasses**: implement the rules for default, commission, and
  production employees.
- **`EmployeeService`**: contains employee creation and payroll operations.
- **`EmployeeRepository`**: stores and retrieves employees in memory.
- **`CreateEmployeeDto`**: groups the data required to create each employee
  type.
- **`EmployeeType`**: identifies the available employee categories.

## Requirements

- JDK 25 or a compatible Java version configured to support Java 25 features.
- Apache Maven.

The required Java version is defined in [`pom.xml`](pom.xml).

## How to Run

1. Clone or download this repository.
2. Open a terminal in the project root.
3. Compile the project with Maven:

   ```bash
   mvn compile
   ```

4. Run the application:

   ```bash
   java -cp target/classes Main
   ```

Alternatively, compile the sources and run `Main` from an IDE with Java and
Maven support.

## Example Workflow

After starting the application:

1. Select `1` to create an employee.
2. Select the employee type.
3. Enter the employee's registration number and name.
4. Enter the additional information requested for commission or production
   employees.
5. Select `2` to view detailed salary information.
6. Select `3` to view the total payroll and average salary.

## Academic Purpose

This project was created as a practical assessment for the Algorithms and
Programming Logic course. Its purpose is to apply programming fundamentals in
a complete, interactive example, including input processing, conditional
logic, repetition, calculations, data organization, and object-oriented
design.

## Limitations

- Employee data is stored only in memory and is lost when the application
  closes.
- There is no database or file persistence.
- The current implementation uses a fixed base salary.
- The interface is available through the terminal only.
