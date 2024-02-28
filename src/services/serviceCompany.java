package services;

import entities.persons.Company;
import entities.persons.Person;
import entities.resources.RoomRate;
import enumerations.PrivilegeLevel;
import utils.Utility;

import java.util.List;
import java.util.Scanner;

import static application.Program.doFirstInteraction;

public class serviceCompany {
    static Scanner sc = new Scanner(System.in);
    public static void interactsCompany(Company company, List<RoomRate> roomRateList){
        company.setPrivilegeLevel(PrivilegeLevel.COMPANY);
        int option;
        Utility.printMessage("********WELCOME TO OUR PAGE TO EIN PERSON*********\n");
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
                    Request.occupiesCompany(company, roomRateList);
                    break;
                }
                case 2 -> {
                    Request.reserveCompany(company);
                    break;
                }
                case 3 -> {
                    Request.cancelCompany(company);
                    break;
                }
                case 4 -> {
                    System.out.println("O/o - Occupancy\nR/r-Reserve\n\n");
                    String choose = sc.nextLine();
                    if (choose.equalsIgnoreCase("o")){
                        Query.queryOccupancyCompany(company, roomRateList);
                    }
                    else if (choose.equalsIgnoreCase("r")){
                        Query.queryReserveCompany(company);
                    }
                    else{
                        System.out.println("Option no-existent!\n");
                    }
                    break;
                }
                case 5 -> {
                    Query.queryCancellationCompany(company);
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
