package application;

import entities.resources.RoomRate;
import utils.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static services.serviceEmployee.employeeLogin;
import static services.servicePerson.distinguishPerson;

public class Program {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        doFirstInteraction();
    }
    public static void doFirstInteraction(){
        List<RoomRate> roomRateList = new ArrayList<>();
        Utility.printMessage("Welcome, dear, to our hotel system.\n");
        System.out.println("        Introduce yourself          \n" +
                "                   E/e - Employee              \n" +
                "                   C/c - Client                \n" +
                "                   O/o - Logout                \n\n");
        String option = sc.nextLine();

        switch (option.toLowerCase()){
            case "e" -> {
                employeeLogin();
            }
            case "c" -> {
                distinguishPerson(roomRateList);
            }
            case "o" -> {
               Utility.printMessage("It was a pleasure spending these simple \n" +
                                    "moments with you, see you later!\n\n");
               System.exit(0);
            }
            default -> {
                Utility.printMessage("Sorry, however this option´s no-existent.");
                return;
            }
        }
    }
}