package assignments2;

import java.lang.*;
import java.util.*;
import java.io.*; 

public class Assignments2 {
    /*
        This method should return the sum of salaries of employees having salary greater than 5000
        Note: Employee array is passed, not employee
     */
    public static double salaryGreaterThanFiveThousand(Employee[] employees) {
        // @TODO
        double sum = 0.0;
        for (Employee employee : employees) {
            if (employee.getSalary() > 5000) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }
    
    
    /*
        This method should print either "Fizz", "Buzz" or "FizzBuzz"
        "Fizz" - if id of employee is divisible by 3
        "Buzz" - if id of employee is divisible by 5
        "FizzBuzz" - if id of employee is divisible by both 3 and 5
     */
    public static void fizzBuzz(Employee employee) {
        // @TODO
        if (employee.getId() % 3 == 0 && employee.getId() % 5 == 0) {
            System.out.println("FizzBuzz");
        }else if(employee.getId() % 3 == 0) {
            System.out.println("Fizz");
        }else if(employee.getId() % 5 == 0) {
            System.out.println("Buzz");
        }
    }
    
    
    /*
        This method should calculate tax for an employee in dollars
        If salary of employee is less than or equal to 2500, tax should be 10%
        If salary of employee is greater than 2500 but less than or equal to 5000, tax should be 25%
        If salary of employee is greater than 5000, tax should be 35%
    */
    public static double calculateTax(Employee employee) {
        // @TODO
        if (employee.getSalary() > 5000) {
            return employee.getSalary() * 0.35;
        }else if(employee.getSalary() > 2500) {
            return employee.getSalary() * 0.25;
        }else {
            return employee.getSalary() * 0.1;
        }
        
    }
    
    
    /*
        We are given two employee objects.
        Implement this method to swap salaries of employees
    */
    public static void swap(Employee firstEmployee, Employee secondEmployee) {
        // @TODO
        double temp = firstEmployee.getSalary();
        firstEmployee.setSalary(secondEmployee.getSalary());
        secondEmployee.setSalary(temp);
    }
    
    
    /*
        Return number of employees whose age is greater than 50
        Note: Employee array is passed, not employee
     */
    public static int employeesAgeGreaterThan50(Employee[] employees) {
        // @TODO
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getAge() > 50) {
                sum ++;
            }
        }
        return sum;
    }
    
    
    /*
        Implement this method to reverse firstName of employee.
        Ex. Before: employee.getFirstName() -> "John"
        After : employee.getFirstName() -> "nhoJ"
     */
    public void reverseFirstName(Employee employee) {
        // @TODO
        StringBuilder str = new StringBuilder();
        str.append(employee.getFirstName());
        str = str.reverse();
        employee.setFirstName(str.toString());
    }
    
    
    /*
        Print "true" if employee's first name contain one or more digits
        Print "false" if employee's first name doesn't contain any digit
        Ex: employee.getFirstName() -> "ha8l" == true
        employee.getFirstName() -> "hail" == false
     */
    public static void isContainDigit(Employee employee) {
        // @TODO
        for (int i = 0; i < employee.getFirstName().length(); i ++) {
            if (Character.isDigit(employee.getFirstName().charAt(i))) {
                System.out.println("True");
            }
        }
        System.out.println("False");
    }
    
    
     /*
        Write a method to raise an employee's salary to three times of his/her original salary.
        Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
        DO NOT change the input in this method.
        Try to add a new method in Employee class: public void raiseSalary(double byPercent) 
        Call this new method.
     */
    public static void tripleSalary(Employee employee) {
        // @TODO
        employee.raiseSalary(300);
    }
    
    
    //Additional question for extra credit
    /*
        Implement this method to convert String[] to employees array.
        Ex: String[] employees = new String[]{"1,John,24,7500", "2,Hail,28,7899.90"};
        This String array of length 2 contains 2 employees in form of string, where
        id = 1
        firstName=John
        age=24
        salary=7500
        convert each string to employee object.
        Hint: Use String methods. Refer : https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
     */
    public static Employee[] createEmployees(String[] employeesStr) {
        Employee[] employees = new Employee[employeesStr.length];
        // @TODO
        for (int i = 0; i < employeesStr.length; i ++){
            String[] initInfo = employeesStr[i].split(",");
            employees[i] = new Employee(Integer.parseInt(initInfo[0]), initInfo[1], Integer.parseInt(initInfo[2]), Double.parseDouble(initInfo[3]));
        }
        return employees;
    }
    
    public static void main(String[] args) {
        String[] employees = new String[]{"3,Joh84n,24,3500", "5,Hail,55,7899.90"};
        Employee[] empList = createEmployees(employees);
        for (Employee e : empList) {
            System.out.println(e.getId() + " " + e.getFirstName() + " " + e.getAge() + " " + e.getSalary());
            fizzBuzz(e);
            System.out.println("calculate Tax = " + calculateTax(e));
//          reverseFirstName(e);
//          System.out.println("reversed firstname: " + e.getFirstName());
            System.out.println("name is Contain Digit: ");
            isContainDigit(e);
            tripleSalary(e);
            System.out.println("salary after triple: " + e.getSalary());
        }
        System.out.println("salaryGreaterThanFiveThousand: " + salaryGreaterThanFiveThousand(empList));
        System.out.println("employeesAgeGreaterThan50: " + employeesAgeGreaterThan50(empList));
        
        swap(empList[0], empList[1]);
        System.out.println("swapping salary: ");
        for (Employee e : empList) {
            System.out.println("salary of "+e.getFirstName()+ " = " + e.getSalary());
        }
    }
}


