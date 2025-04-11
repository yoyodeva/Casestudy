package com.payxpert.app;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import com.payxpert.model.*;
import com.payxpert.service.*;
import java.util.Scanner;
import com.payxpert.dao.impl.*;
import com.payxpert.dao.*;


public class PayXpertApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EmployeeService employeeService = new EmployeeServiceImpl();
        PayrollDAO payrollDAO = new PayrollDAOImpl();
        PayrollService payrollService = new PayrollServiceImpl(payrollDAO);
        TaxService taxService = new TaxServiceImpl();
        FinancialRecordService financialRecordService = new FinancialRecordServiceImpl();

        System.out.println("=== Welcome to PayXpert Payroll Management System ===");

        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Get Employee By ID");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Add Payroll");
            System.out.println("6. Get Payroll By ID");
            System.out.println("7. Add Tax");
            System.out.println("8. Get Tax By ID");
            System.out.println("9. Add Financial Record");
            System.out.println("10. Get Financial Record By ID");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
            case 1:
                Employee emp = new Employee();
                System.out.print("Enter Employee First Name: ");
                emp.setFirstName(sc.nextLine());

                System.out.print("Enter Employee Last Name: ");
                emp.setLastName(sc.nextLine());

                System.out.print("Enter Employee Email: ");
                emp.setEmail(sc.nextLine());

                System.out.print("Enter Employee Phone Number: ");
                emp.setPhoneNumber(sc.nextLine());

                emp.setHireDate(new java.util.Date());  

                System.out.print("Enter Job Title: ");
                emp.setJobTitle(sc.nextLine());

                System.out.print("Enter Department: ");
                emp.setDepartment(sc.nextLine());

                System.out.print("Enter Salary: ");
                emp.setSalary(sc.nextDouble());
                sc.nextLine(); 

                employeeService.addEmployee(emp);
                System.out.println("Employee added successfully.");
                break;


                case 2:
                    System.out.print("Enter Employee ID: ");
                    int empId = sc.nextInt();
                    Employee employee = employeeService.getEmployeeById(empId);
                    System.out.println(employee);
                    break;
                    
                    
                case 3: 
                    System.out.print("Enter Employee ID to Update: ");
                    int updateEmpId = sc.nextInt();
                    sc.nextLine(); 

                    Employee existingEmployee = employeeService.getEmployeeById(updateEmpId);
                    if (existingEmployee != null) {
                        System.out.print("Enter New First Name (" + existingEmployee.getFirstName() + "): ");
                        String firstName = sc.nextLine();
                        if (!firstName.isEmpty()) existingEmployee.setFirstName(firstName);

                        System.out.print("Enter New Last Name (" + existingEmployee.getLastName() + "): ");
                        String lastName = sc.nextLine();
                        if (!lastName.isEmpty()) existingEmployee.setLastName(lastName);

                        System.out.print("Enter New Email (" + existingEmployee.getEmail() + "): ");
                        String email = sc.nextLine();
                        if (!email.isEmpty()) existingEmployee.setEmail(email);

                        System.out.print("Enter New Phone Number (" + existingEmployee.getPhoneNumber() + "): ");
                        String phone = sc.nextLine();
                        if (!phone.isEmpty()) existingEmployee.setPhoneNumber(phone);

                        System.out.print("Enter New Job Title (" + existingEmployee.getJobTitle() + "): ");
                        String jobTitle = sc.nextLine();
                        if (!jobTitle.isEmpty()) existingEmployee.setJobTitle(jobTitle);

                        System.out.print("Enter New Department (" + existingEmployee.getDepartment() + "): ");
                        String department = sc.nextLine();
                        if (!department.isEmpty()) existingEmployee.setDepartment(department);

                        System.out.print("Enter New Salary (" + existingEmployee.getSalary() + "): ");
                        String salaryInput = sc.nextLine();
                        if (!salaryInput.isEmpty()) existingEmployee.setSalary(Double.parseDouble(salaryInput));

                        employeeService.updateEmployee(existingEmployee);
                        System.out.println("Employee updated successfully.");
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 4:
                    
                    System.out.print("Enter Employee ID to Delete: ");
                    int deleteEmpId = sc.nextInt();
                    sc.nextLine();

                    boolean isDeleted = employeeService.deleteEmployee(deleteEmpId);
                    if (isDeleted) {
                        System.out.println("Employee deleted successfully.");
                    } else {
                        System.out.println("Employee not found or could not be deleted.");
                    }
                    break;


               
                case 5:
                    Payroll payroll = new Payroll();
                    System.out.print("Enter Employee ID for Payroll: ");
                    payroll.setEmployeeId(sc.nextInt());
                    System.out.print("Enter Basic Pay: ");
                    payroll.setBasicSalary(sc.nextDouble());
                    System.out.print("Enter Allowances: ");
                    payroll.setAllowances(sc.nextDouble());
                    System.out.print("Enter Deductions: ");
                    payroll.setDeductions(sc.nextDouble());
                    
                    sc.nextLine();
                    
                    System.out.print("Enter Pay Date (yyyy-MM-dd): ");
                    String dateStr = sc.nextLine();
                    payroll.setPayDate(LocalDate.parse(dateStr));

                    payrollService.addPayroll(payroll);
                    System.out.println("Payroll added successfully.");
                    break;


                case 6:
                    System.out.print("Enter Payroll ID: ");
                    int payrollId = sc.nextInt();
                    Payroll pr = payrollService.getPayrollById(payrollId);
                    System.out.println(pr);
                    break;

                case 7:
                    Tax tax = new Tax();
                    System.out.print("Enter Employee ID for Tax: ");
                    tax.setEmployeeId(sc.nextInt());
                    System.out.print("Enter Tax Amount: ");
                    tax.setTaxAmount(sc.nextDouble());
                    sc.nextLine();
                    System.out.print("Enter Tax Year: ");
                    tax.setTaxYear(sc.nextInt()); 
                    sc.nextLine();
                    taxService.addTax(tax);
                    System.out.println("Tax record added successfully.");
                    break;

                case 8:
                    System.out.print("Enter Tax ID: ");
                    int taxId = sc.nextInt();
                    Tax tx = taxService.getTaxById(taxId);
                    System.out.println(tx);
                    break;

                case 9:
                	FinancialRecord fr = new FinancialRecord();

                	System.out.print("Enter Employee ID for Financial Record: ");
                	fr.setEmployeeId(sc.nextInt());
                	sc.nextLine(); 

                	System.out.print("Enter Record Date (yyyy-mm-dd): ");
                	String dateInput = sc.nextLine();
                	fr.setRecordDate(Date.valueOf(dateInput));

                	System.out.print("Enter Description: ");
                	fr.setDescription(sc.nextLine());

                	System.out.print("Enter Amount: ");
                	fr.setAmount(sc.nextDouble());
                	sc.nextLine(); 

                	System.out.print("Enter Record Type (Credit/Debit): ");
                	fr.setRecordType(sc.nextLine());

                	financialRecordService.addFinancialRecord(fr);
                	System.out.println("Financial Record added successfully.");
                	break;


                case 10:
                    System.out.print("Enter Financial Record ID: ");
                    int frId = sc.nextInt();
                    FinancialRecord financialRecord = financialRecordService.getFinancialRecordById(frId);
                    System.out.println(financialRecord);
                    break;

                case 11:
                    exit = true;
                    System.out.println("Thank you for using PayXpert!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}
