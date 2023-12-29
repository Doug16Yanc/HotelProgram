package services;

import entities.persons.Company;
import entities.persons.Individual;
import entities.persons.Person;
import entities.resources.Room;
import entities.resources.RoomRate;
import enumerations.DailySituation;
import enumerations.PrivilegeLevel;
import enumerations.RoomSituation;
import repositories.Calculate;
import utils.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Daily implements Calculate {
    static Scanner sc = new Scanner(System.in);
    static LocalDateTime date = LocalDateTime.now();
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private static final List<RoomRate> roomList = new ArrayList<>();
    public static List<RoomRate> getRoomList() {
        return roomList;
    }

    public static int generateID() {
        Random random = new Random();
        int enter = random.nextInt(100, 1000000000);

        boolean aux;

        while (true) {
            aux = true;

            for (RoomRate daily : getRoomList()) {
                if (enter == daily.getIdDaily()) {
                    aux = false;
                    break;
                }
            }

            if (aux) {
                return enter;
            }
            else {
                enter = random.nextInt(100, 1000000000);
            }
        }
    }
    public static void recordDailyIndividual(int foundNumber, int number){
        Utility.printMessage("Dear, I ask you to read carefully, the daily rate\n" +
                            "registration is made only in the name of a requester,\n" +
                            "so it will be filled in with this data.\n");

        int id = servicePerson.generateID();

        System.out.println("Enter your name:");
        String name = sc.nextLine();

        System.out.println("Enter your address:");
        String address = sc.nextLine();

        System.out.println("Enter your email:");
        String email = sc.nextLine();

        System.out.println("Enter your origin:");
        String origin = sc.nextLine();

        System.out.println("Enter your ssn:");
        String ssn = sc.nextLine();

        System.out.println("Enter your birthday date:");
        String birthday = sc.nextLine();

        Individual individual = new Individual(id, name, address, email, origin, PrivilegeLevel.INDIVIDUAL, ssn, birthday);
        servicePerson.getPersonList().add(individual);
        proofOccupancyIndividual(individual, foundNumber, number);
    }
    public static void proofOccupancyIndividual(Individual individual, int foundNumber, int number){
        generateID();
        Room room = new Room();
        room.setSituation(RoomSituation.BUSY);
        int idDaily = generateID();
        String dateDaily =  date.format(formatter);
        double value = doCalculation(individual, room, number);
        Utility.printMessage("*********PROOF OF ROOM OCCUPANCY*********\n");
        System.out.println("            INDIVIDUAL DATA         \n\n" +
                          "             > Name : " + individual.getName() + "\n" +
                          "             > Id : " + individual.getId() + "\n" +
                          "             > Address : " + individual.getAddress() + "\n" +
                          "             > Email : " + individual.getEmail() + "\n" +
                          "             > Origin : " + individual.getOrigin() + "\n" +
                          "             > SSN : " + individual.getSsn() + "\n" +
                          "             > Birthday date : " + individual.getBirthday() + "\n" +
                          "             > Client type : " + individual.getPrivilegeLevel() + "\n\n" +
                          "             ROOM DATA       \n\n" +
                          "             > Room number : " + foundNumber + "\n\n" +
                          "             OCCUPANCY DATA                    \n\n" +
                          "             > Id occupancy : " + idDaily + "\n" +
                          "             > Date : " + dateDaily + "\n" +
                          "             > Daily value : US$ " + String.format("%.2f", value) + "\n\n");

        RoomRate roomRate = new RoomRate(idDaily, dateDaily, value, DailySituation.SETTLED);

        roomList.add(roomRate);
    }
    public static void recordDailyCompany(int foundNumber, int number){
        Utility.printMessage("Dear, I ask you to read carefully, the daily rate\n" +
                "registration is made only in the name of a requester,\n" +
                "so it will be filled in with this data.\n");

        int id = servicePerson.generateID();

        System.out.println("Enter your name:");
        String name = sc.nextLine();

        System.out.println("Enter your address:");
        String address = sc.nextLine();

        System.out.println("Enter your email:");
        String email = sc.nextLine();

        System.out.println("Enter your origin:");
        String origin = sc.nextLine();

        System.out.println("Enter your ein:");
        String ein = sc.nextLine();

        Company company = new Company(id, name, address, email, origin, PrivilegeLevel.COMPANY, ein);
        servicePerson.getPersonList().add(company);
        proofOccupancyCompany(company, foundNumber, number);
    }
    public static void proofOccupancyCompany(Company company, int foundNumber, int number){
        generateID();
        Room room = new Room();
        room.setSituation(RoomSituation.BUSY);
        int idDaily = generateID();
        String dateDaily =  date.format(formatter);
        double value = doCalculation(company, room, number);
        Utility.printMessage("*********PROOF OF ROOM OCCUPANCY*********\n");
        System.out.println("            INDIVIDUAL DATA         \n\n" +
                "             > Name : " + company.getName() + "\n" +
                "             > Id : " + company.getId() + "\n" +
                "             > Address : " + company.getAddress() + "\n" +
                "             > Email : " + company.getEmail() + "\n" +
                "             > Origin : " + company.getOrigin() + "\n" +
                "             > EIN : " + company.getEin() + "\n" +
                "             > Client type : " + company.getPrivilegeLevel() + "\n\n" +
                "             ROOM DATA       \n\n" +
                "             > Room number : " + foundNumber + "\n\n" +
                "             OCCUPANCY DATA                    \n\n" +
                "             > Id occupancy : " + idDaily + "\n" +
                "             > Date : " + dateDaily + "\n" +
                "             > Daily value : US$ " + String.format("%.2f", value)  + "\n\n");

        RoomRate roomRate = new RoomRate(idDaily, dateDaily, value, DailySituation.SETTLED);

        roomList.add(roomRate);
    }
    public static double doCalculation(Person person, Room room, int number){
        double value = 250.00*number;
        if (person.getPrivilegeLevel() == PrivilegeLevel.COMPANY && room.getSituation() == RoomSituation.BUSY) {
            value *= 1.02204;
        }
        else if(person.getPrivilegeLevel() == PrivilegeLevel.INDIVIDUAL && room.getSituation() == RoomSituation.BUSY) {
            value *= 1.011515;
        }
        else if (person.getPrivilegeLevel() == PrivilegeLevel.COMPANY && room.getSituation() == RoomSituation.RESERVED) {
            value *= 1.061106;
        }
        else if (person.getPrivilegeLevel() == PrivilegeLevel.INDIVIDUAL && room.getSituation() == RoomSituation.RESERVED){
            value *= 1.01505;
        }
        return value;
    }
}
