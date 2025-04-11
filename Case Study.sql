CREATE DATABASE PayXpertDB;
USE PayXpertDB;
CREATE TABLE Employee (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone_number VARCHAR(20),
    hire_date DATE NOT NULL,
    job_title VARCHAR(50),
    department VARCHAR(50),
    salary DECIMAL(10, 2) NOT NULL
);
CREATE TABLE Payroll (
    payroll_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT,
    pay_date DATE NOT NULL,
    basic_salary DECIMAL(10, 2) NOT NULL,
    bonus DECIMAL(10, 2) DEFAULT 0,
    deductions DECIMAL(10, 2) DEFAULT 0,
    net_salary DECIMAL(10, 2),
    FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);
CREATE TABLE Tax (
    tax_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT,
    tax_year YEAR NOT NULL,
    tax_amount DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);
CREATE TABLE FinancialRecord (
    record_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT,
    record_date DATE NOT NULL,
    description VARCHAR(255),
    amount DECIMAL(10, 2) NOT NULL,
    record_type ENUM('Credit', 'Debit') NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);
INSERT INTO Employee (first_name, last_name, email, phone_number, hire_date, job_title, department, salary)
VALUES
('John', 'Doe', 'john.doe@example.com', '1234567890', '2023-01-15', 'Software Engineer', 'IT', 75000.00),
('Jane', 'Smith', 'jane.smith@example.com', '2345678901', '2022-03-20', 'HR Manager', 'HR', 65000.00),
('Alice', 'Johnson', 'alice.johnson@example.com', '3456789012', '2024-06-10', 'Accountant', 'Finance', 58000.00),
('Bob', 'Brown', 'bob.brown@example.com', '4567890123', '2021-11-05', 'Sales Executive', 'Sales', 60000.00),
('Charlie', 'Davis', 'charlie.davis@example.com', '5678901234', '2023-09-25', 'Marketing Lead', 'Marketing', 72000.00),
('Emily', 'Wilson', 'emily.wilson@example.com', '6789012345', '2022-05-14', 'Business Analyst', 'IT', 70000.00),
('Frank', 'Taylor', 'frank.taylor@example.com', '7890123456', '2021-08-01', 'Recruiter', 'HR', 55000.00),
('Grace', 'Lee', 'grace.lee@example.com', '8901234567', '2024-02-28', 'Financial Analyst', 'Finance', 62000.00),
('Henry', 'Walker', 'henry.walker@example.com', '9012345678', '2023-12-12', 'Product Manager', 'Marketing', 80000.00),
('Ivy', 'Martin', 'ivy.martin@example.com', '1123456789', '2022-07-07', 'Software Tester', 'IT', 68000.00);

INSERT INTO Payroll (employee_id, pay_date, basic_salary, bonus, deductions, net_salary)
VALUES
(1, '2025-03-31', 75000.00, 5000.00, 2000.00, 78000.00),
(2, '2025-03-31', 65000.00, 3000.00, 1500.00, 66500.00),
(3, '2025-03-31', 58000.00, 2000.00, 1000.00, 59000.00),
(4, '2025-03-31', 60000.00, 2500.00, 1200.00, 61300.00),
(5, '2025-03-31', 72000.00, 4000.00, 1500.00, 74500.00),
(6, '2025-03-31', 70000.00, 3500.00, 1300.00, 72200.00),
(7, '2025-03-31', 55000.00, 1000.00, 800.00, 55200.00),
(8, '2025-03-31', 62000.00, 2500.00, 900.00, 63600.00),
(9, '2025-03-31', 80000.00, 6000.00, 2500.00, 83500.00),
(10, '2025-03-31', 68000.00, 3000.00, 1200.00, 69800.00);

INSERT INTO Tax (employee_id, tax_year, tax_amount)
VALUES
(1, 2025, 15000.00),
(2, 2025, 12000.00),
(3, 2025, 11000.00),
(4, 2025, 11500.00),
(5, 2025, 14000.00),
(6, 2025, 13800.00),
(7, 2025, 9500.00),
(8, 2025, 10800.00),
(9, 2025, 16000.00),
(10, 2025, 12500.00);

INSERT INTO FinancialRecord (employee_id, record_date, description, amount, record_type)
VALUES
(1, '2025-03-01', 'Laptop Purchase', 1200.00, 'Debit'),
(2, '2025-03-02', 'Travel Reimbursement', 500.00, 'Credit'),
(3, '2025-03-03', 'Conference Fee', 800.00, 'Debit'),
(4, '2025-03-04', 'Team Lunch', 300.00, 'Debit'),
(5, '2025-03-05', 'Performance Bonus', 2000.00, 'Credit'),
(6, '2025-03-06', 'Stationery Expenses', 150.00, 'Debit'),
(7, '2025-03-07', 'Medical Claim', 700.00, 'Credit'),
(8, '2025-03-08', 'Training Cost', 900.00, 'Debit'),
(9, '2025-03-09', 'Gift Card', 400.00, 'Credit'),
(10, '2025-03-10', 'Office Maintenance', 600.00, 'Debit');

Select*FROM EMPLOYEE;
select*from FinancialRecord;
select*from payroll;
select*from tax;


