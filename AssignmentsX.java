package com.itranswarp.sample;
//
import java.util.Objects;

public class Assignments2 {
    private static final String ORGANISATION = "Northeastern";
    private static final String[] STRS = new String[] {
            //firstname,lastname,age,salary,email,designation
            "John,Doe,24,5400,johndoe@gmail.com,Engineer",
            "Sara,Jones,26,6300,sarajones@gmail.com,TechnicalRecruiter",
            "Noah,Trevor,32,5300,noahtrevor@gmail.com,Writer",
            "Jill,Meyer,34,6800,jillmeyer@gmail.com,Manager",
            "Chris,Strat,36,7600,chrisstrat@gmail.com,Director",
            "Ching,Chi,25,4000,chingchi@gmail.com,Developer",
            "Yue,Hui,28,4900,yuehui@gmail.com,Tester",
            "Amit,Agarwal,27,5700,yuehui@gmail.com,SeniorDeveloper",
            "Tianyu,Wang,26,4500,tianyuwang@gmail.com,Researcher",
            "Ram,Menon,29,5700,rammenon@gmail.com,DataScientist"
    };

    private final Employee[] employees = new Employee[10];

    class Employee implements Comparable<Employee> {
        private String firstName;
        private String lastName;
        private int age;
        private int salary;
        private String email;
        private String designation;
        private String org;

        Employee(String firstName, String lastName, int age, int salary, String email, String designation, String org) {
            // @TODO
            // initialize all members here
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.salary = salary;
            this.email = email;
            this.designation = designation;
            this.org = org;
        }

        // generate getter setters for all Employee members

        @Override
        public int compareTo(Employee o) {
            // @TODO
            // compare employee by their salary, if salaries are equal, compare by age
            if (o instanceof Employee) {
                Employee emp = (Employee) o;
                int i = this.salary.compareTo(emp.salary);
                
                if (i == 0) {
                    return this.age.compareTo(emp.age);
                }else {
                    return i;
                }
            }
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Employee other = (Employee) obj;
            if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
                return false;
            if (age != other.age)
                return false;
            if (designation == null) {
                if (other.designation != null)
                    return false;
            } else if (!designation.equals(other.designation))
                return false;
            if (email == null) {
                if (other.email != null)
                    return false;
            } else if (!email.equals(other.email))
                return false;
            if (firstName == null) {
                if (other.firstName != null)
                    return false;
            } else if (!firstName.equals(other.firstName))
                return false;
            if (lastName == null) {
                if (other.lastName != null)
                    return false;
            } else if (!lastName.equals(other.lastName))
                return false;
            if (org == null) {
                if (other.org != null)
                    return false;
            } else if (!org.equals(other.org))
                return false;
            if (salary != other.salary)
                return false;
            return true;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getEnclosingInstance().hashCode();
            result = prime * result + age;
            result = prime * result + ((designation == null) ? 0 : designation.hashCode());
            result = prime * result + ((email == null) ? 0 : email.hashCode());
            result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
            result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
            result = prime * result + ((org == null) ? 0 : org.hashCode());
            result = prime * result + salary;
            return result;
        }

        private Assignments2 getEnclosingInstance() {
            return Assignments2.this;
        }
    }//class define ends

    public void initializeEmployees() {
        // @TODO
        // use STRS to create employee objects and store them in employees array
        for (int i = 0; i < employees.length; i ++){
            String[] initInfo = STRS[i].split(",");
            employees[i] = new Employee(initInfo[0], initInfo[1], Integer.parseInt(initInfo[2]), Integer.parseInt(initInfo[3]), initInfo[4], initInfo[5], ORGANISATION);
        }
        
    }

    public int sumOfSalariesGreaterThanFiveThousands() {
        // @TODO
        // calculate the sum of salaries of employees having salary greater than 5000
        int sum = 0;
        for (Employee e : employees) {
            if (e.salary > 5000) {
                sum += e.salary;
            }
        }
        return sum;
    }
    
    public static void swap(Employee e1, Employee e2) {
        int temp = e1.salary;
        e1.salary = e2.salary;
        e2.salary = temp;
    }

    public void swapSalaries() {
        // @TODO
        // swap salary of even numbered employee with odd numbered employee
        // swap salary of employees[0] with employees[1], employees[2] with employees[3] and so on..
        for (int i = 0; i < employees.length; i ++) {
            if (i % 2 == 0) {
                swap(employees[i], employees[i + 1]);
            }
        }
    }

    public void customSort() {
        // @TODO
        // sort employees array on the basis of firstName and print
        
        for(Employee employee : employees) {
            System.out.println(employee.firstName);
        }

        // @TODO
        // sort employees array on the basis of age and print

        for(Employee employee : employees) {
            System.out.println(employee.firstName);
        }
    }

    public static void main(String[] args) {
        Assignment2 assignment2 = new Assignment2();
        // you can verify/test your code here
    }
}
