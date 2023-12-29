package services;

import entities.persons.Person;
import utils.Utility;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static application.Program.doFirstInteraction;

public class serviceIndividual {
    static Scanner sc = new Scanner(System.in);
    public static void interactsIndividual(Person person){
        int option;
        Utility.printMessage("********WELCOME TO OUR PAGE TO SSN PERSON*********\n");
        do {
            System.out.println("          Please, select your option            \n\n" +
                    "                REQUISITIONS                    \n\n" +
                    "           1 - Request occupancy                \n" +
                    "           2 - Request reserve                  \n" +
                    "           3 - Request cancellation             \n\n" +
                    "                QUERIES                         \n\n" +
                    "           4 - Query occupancy/reserve          \n" +
                    "           5 - Query cancellations              \n\n" +
                    "                SYSTEM MANAGEMENT               \n\n" +
                    "            6 - Return to top                   \n");
            option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    Request.occupiesIndividual(person);
                    break;
                }
                case 2 -> {
                    Request.reserveIndividual(person);
                    break;
                }
                case 3 -> {
                    Request.cancelIndividual(person);
                    break;
                }
                case 4 -> {
                    System.out.println("O/o - Occupancy\nR/r-Reserve\n\n");
                    String choose = sc.nextLine();
                    if (choose.equalsIgnoreCase("o")){
                        Query.queryOccupancyIndividual(person);
                    }
                    else if (choose.equalsIgnoreCase("r")){
                        Query.queryReserveIndividual(person);
                    }
                    else{
                        System.out.println("Option no-existent!\n");
                    }
                    break;
                }
                case 5 -> {
                    Query.queryCancellationIndividual(person);
                    break;
                }
                case 6 -> {
                    doFirstInteraction();
                    break;
                }
                default -> {
                    System.out.println("Option no-existent.\n");
                    break;
                }
            }
        } while(option != 6);
    }
}
