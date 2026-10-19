import com.codebyallan.paysheet.dto.CreateEmployeeDto;
import com.codebyallan.paysheet.enums.EmployeeType;
import com.codebyallan.paysheet.model.Employee;
import com.codebyallan.paysheet.repository.EmployeeRepository;
import com.codebyallan.paysheet.service.EmployeeService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        var employees = new ArrayList<Employee>();
        var repo = new EmployeeRepository(employees);
        var service = new EmployeeService(repo);

        Scanner sc = new Scanner(System.in);
        int menu = 0;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Criar Funcionário");
            System.out.println("2. Gerar Folha de Pagamento");
            System.out.println("3. Exibir Resumo da Folha de Pagamento");
            System.out.println("9. Sair");

            if (sc.hasNextInt()) {
                menu = sc.nextInt();
            } else {
                System.out.println("Erro: Por favor, digite apenas números válidos!\n");
                sc.next();
                continue;
            }

            if (menu == 1) {
                System.out.println("1. Funcionário Padrão");
                System.out.println("2. Funcionário Comissionado");
                System.out.println("3. Funcionário de Produção");

                int option;
                if (sc.hasNextInt()) {
                    option = sc.nextInt();
                } else {
                    System.out.println("Erro: Por favor, digite apenas números válidos!\n");
                    sc.next();
                    continue;
                }

                System.out.print("Digite a matrícula do funcionário: ");
                int registration;
                if (sc.hasNextInt()) {
                    registration = sc.nextInt();
                    sc.nextLine();
                } else {
                    System.out.println("Erro: Por favor, digite apenas números!\n");
                    sc.next();
                    continue;
                }

                System.out.print("Digite o nome do funcionário: ");
                String name = sc.nextLine();

                CreateEmployeeDto dto;
                switch (option) {
                    case 1 -> {
                        dto = new CreateEmployeeDto(registration, name, EmployeeType.DEFAULT, null, null, null, null);
                        service.createEmployee(dto);
                        System.out.println("Sucesso: Funcionário Padrão criado!");
                    }
                    case 2 -> {
                        System.out.print("Digite o valor das vendas: ");
                        double sellingValue = 0.0;
                        if (sc.hasNextDouble()) {
                            sellingValue = sc.nextDouble();
                        } else {
                            System.out.println("Erro: Por favor, digite um valor válido!\n");
                            sc.next();
                            break;
                        }

                        System.out.print("Digite o percentual da comissão: ");
                        int commissionPercentage = 0;
                        if (sc.hasNextInt()) {
                            commissionPercentage = sc.nextInt();
                        } else {
                            System.out.println("Erro: Por favor, digite apenas o número da porcentagem!\n");
                            sc.next();
                            break;
                        }

                        dto = new CreateEmployeeDto(registration, name, EmployeeType.COMMISSION, sellingValue, commissionPercentage, null, null);
                        service.createEmployee(dto);
                        System.out.println("Sucesso: Funcionário Comissionado criado!");
                    }
                    case 3 -> {
                        System.out.print("Digite a quantidade de peças feitas: ");
                        int partsQtd = 0;
                        if (sc.hasNextInt()) {
                            partsQtd = sc.nextInt();
                        } else {
                            System.out.println("Erro: Por favor, digite um número inteiro!\n");
                            sc.next();
                            break;
                        }

                        System.out.print("Digite o valor por peça: ");
                        double partsValue = 0.0;
                        if (sc.hasNextDouble()) {
                            partsValue = sc.nextDouble();
                        } else {
                            System.out.println("Erro: Por favor, digite um valor válido!\n");
                            sc.next();
                            break;
                        }

                        dto = new CreateEmployeeDto(registration, name, EmployeeType.PRODUCTION, null, null, partsQtd, partsValue);
                        service.createEmployee(dto);
                        System.out.println("Sucesso: Funcionário de Produção criado!");
                    }
                    default -> System.out.println("Erro: Opção de tipo de funcionário inválida!");
                }
            } else if (menu == 2) {
                service.generatePaySheet();
            } else if (menu == 3) {
                service.generateResumePaySheet();
            } else if (menu != 9) {
                System.out.println("Erro: Opção inválida do menu principal.");
            }

        } while (menu != 9);

        sc.close();
        System.out.println("Programa encerrado com sucesso.");
    }
}