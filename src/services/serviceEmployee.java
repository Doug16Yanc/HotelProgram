package services;

import entities.persons.Employee;
import utils.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class serviceEmployee {
    static Scanner sc = new Scanner(System.in);
    public static void employeeLogin(){

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("Dooglahs", "Doog", "2030"));
        employeeList.add(new Employee("Dughlas", "Dugh", "4070"));
        employeeList.add(new Employee("Dubhghlas", "Dubh", "5080"));

        System.out.println("The access to staff at this hotel\n" +
                          "are entered after logging by confirming with\n" +
                          "username and password.\n\n");

        int attempts = 3;

        do {
            System.out.println("Enter your username:");
            String username = sc.nextLine();

            System.out.println("Enter your password:");
            String password = sc.nextLine();

            Employee foundEmployee = null;

            for (Employee emp : employeeList) {
                if (emp.getUsername().equals(username) && emp.getPassword().equals(password)) {
                    foundEmployee = emp;
                    break;
                }
            }
            if (foundEmployee != null) {
                Utility.printMessage("Login successful! Welcome " + foundEmployee.getNameEmployee() + ".\n");
                interactsEmployee(foundEmployee);
                break;
            }
            else{
                System.out.println("Username or password not recognized, try again while has chances.\n" +
                        "Chances : " + (attempts - 1) + ".\n");
                attempts--;
            }
        }while(attempts > 0);
    }
    public static void interactsEmployee(Employee employeeList ){
        Utility.printMessage("      YOUR PAGE, DEAR " + employeeList.getNameEmployee().toUpperCase() + "\n");

    }
}
