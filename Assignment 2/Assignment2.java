import java.util.*;

public class Assignment2 {

        /*
            This method should return the sum of salaries of employees having salary greater than 5000
            Note: Employee array is passed, not employee
        */

    public double salaryGreaterThanFiveThousand(Employee[] employees) {
        double sum = 0;
        double salary;
        for(Employee emp : employees){
            salary = emp.getSalary();
            if(salary > 5000)
                sum += salary;
        }
        return sum;
    }


        /*
            This method should print either "Fizz", "Buzz" or "FizzBuzz"
            "Fizz" - if id of employee is divisible by 3
            "Buzz" - if id of employee is divisible by 5
            "FizzBuzz" - if id of employee is divisible by both 3 and 5
        */

    public void fizzBuzz(Employee employee) {
        if (employee == null)
            throw new IllegalArgumentException();
        int id = employee.getId();
        boolean divByThree = id % 3 == 0;
        boolean divByFive = id % 5 == 0;
        if (divByThree && divByFive)
            System.out.println("FizzBuzz");
        else if (divByThree)
            System.out.println("Fizz");
        else if (divByFive)
            System.out.println("Buzz");
    }


        /*
            We are given two employee objects.
            Implement this method to swap salaries of employees
        */

    public void swap(Employee firstEmployee, Employee secondEmployee) {
        if(firstEmployee == null || secondEmployee == null)
            throw new IllegalArgumentException();
        double temp = firstEmployee.getSalary();
        firstEmployee.setSalary(secondEmployee.getSalary());
        secondEmployee.setSalary(temp);
    }


	/*
	     Write a method to calculate the Social Security Tax of an employee and print it.
	     If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
	     If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
	*/

    public double socialSecurityTax(Employee employee) {
        if(employee == null)
            throw new IllegalArgumentException();
        double tax = 0;
        double salary = employee.getSalary();
        if(salary <= 8900)
            tax = 0.062 * salary;
        else
            tax = 0.062 * 106_800;
        return tax;
    }


       	/*
	     Write a method to calculate an employee's contribution for insurance coverage and print it.
	     Amount of deduction is computed as follows:
	     If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
	     If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
	*/

    public static double insuranceCoverage(Employee employee) {
        if(employee == null)
            throw new IllegalArgumentException();
        int age = employee.getAge();
        double salary = employee.getSalary(), rate = 0;
        if(age < 35)
            rate = 0.03 * salary;
        else if(age <= 50)
            rate = 0.04 * salary;
        else if(age < 60)
            rate = 0.05 * salary;
        else
            rate = 0.06 * salary;
        return rate;
    }


	/*
	     Write a method to sort three employees' salary from low to high, and then print their name in order.
	     For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
	     John Alice Jenny
	*/

    public void sortSalary(Employee e1, Employee e2, Employee e3) {
        if(e1 == null || e2 == null || e3 == null)
            throw new IllegalArgumentException();

        Employee[] employees = {e1,e2,e3};

        for(int i=0; i<employees.length; i++){
            for(int j=1; j<employees.length-i; j++){
                if(employees[j-1].getSalary() > employees[j].getSalary()) {
                    Employee temp = employees[j-1];
                    employees[j-1] = employees[j];
                    employees[j] = temp;
                }
            }
        }

        StringBuilder str = new StringBuilder();
        for(Employee emp : employees)
            str.append(emp.getFirstName()).append(" ");
        str.deleteCharAt(str.length()-1);

        System.out.println(str.toString());
    }


    /***************** Additional question for Extra Credit *****************/
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

    public Employee[] createEmployees(String[] employeesStr) {
        Employee[] employees = new Employee[employeesStr.length];
        int i = 0;
        for(String emp : employeesStr){
            String[] empArr = emp.split(",");
            Employee employee = new Employee(Integer.parseInt(empArr[0]),
                                             empArr[1],
                                             Integer.parseInt(empArr[2]),
                                             Double.parseDouble(empArr[3]));
            employees[i++] = employee;
        }
        return employees;
    }
}
