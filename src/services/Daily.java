package services;

import entities.persons.Individual;
import entities.persons.Person;
import entities.resources.Room;
import entities.resources.RoomRate;
import enumerations.PrivilegeLevel;
import enumerations.RoomSituation;
import repositories.Calculate;
import utils.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Daily implements Calculate {
    static Scanner sc = new Scanner(System.in);
    private static final List<RoomRate> roomList = new ArrayList<>();
    public static List<RoomRate> getRoomList() {
        return roomList;
    }
    public static int generateID(List<RoomRate> dailyList) {
        Random random = new Random();
        int enter = random.nextInt(100, 1000000000);

        boolean aux;

        while (true) {
            aux = true;

            for (RoomRate daily : dailyList) {
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
    public static void recordDaily(int number){
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
        proofOccupancyIndividual(individual, number);
    }
    public static void proofOccupancyIndividual(Individual individual, int number){
        generateID(roomList);
        RoomRate roomRate = new RoomRate();
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
                          "             > Room number : " + number + "\n" +
                          "             > Daily value : US$ " + roomRate.getValueDaily(doCalculation(number)) + "\n\n");
    }
    public static Double doCalculation(int number) {
        Person person = new Person();
        Room room = new Room();
        double value = 0;
        if (person.getPrivilegeLevel() == PrivilegeLevel.COMPANY && room.getSituation() == RoomSituation.BUSY){
            value = (250.00*number) + (1.02*250.00) + (1.005*250.00);
        }
        else if (person.getPrivilegeLevel() == PrivilegeLevel.COMPANY && room.getSituation() == RoomSituation.RESERVED){
            value = (250.00*number) + (1.02*250.00) + (1.02*250.00);
        }
        else if (person.getPrivilegeLevel() == PrivilegeLevel.INDIVIDUAL && room.getSituation() == RoomSituation.BUSY) {
            value = (250.00*number) + (1.01*250.00) + (1.002*250.00);
        }
        else if (person.getPrivilegeLevel() == PrivilegeLevel.INDIVIDUAL && room.getSituation() == RoomSituation.RESERVED) {
            value = (250.00*number) + (1.01*250.00) + (1.015*250.00);
        }
        return value;
    }
}
