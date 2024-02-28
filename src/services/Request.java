package services;

import entities.persons.Person;
import entities.resources.Room;
import entities.resources.RoomRate;
import enumerations.PrivilegeLevel;
import enumerations.RoomSituation;
import utils.Utility;

import java.util.List;
import java.util.Scanner;

import static services.Occupancy.*;

public class Request {

    static Scanner sc = new Scanner(System.in);

    public static void occupiesCompany(Person person, List<RoomRate> roomRateList){
        Utility.printMessage("OCCUPANCY");
        System.out.println("The maximum occupancy per room is five people.");
        System.out.println("Number of people to be occupied:");
        int number = sc.nextInt();

        if (number > 5){
           distributeMoreFive(person, number);
        }
        else {
            distributeCommon(person, number, roomRateList);
        }

    }

    public static void reserveCompany(Person person){
        Utility.printMessage("RESERVE");
        System.out.println("Number of people to be reserved:");
        int number = sc.nextInt();
    }
    public static void cancelCompany(Person person){

    }
    public static void occupiesIndividual(Person person, List<RoomRate> roomRateList){
        Utility.printMessage("OCCUPANCY");
        System.out.println("The maximum occupancy per room is five people.");
        System.out.println("Number of people to be occupied:");
        int number = sc.nextInt();

        if (number > 5){
            distributeMoreFive(person, number);
        }
        else {
            distributeCommon(person, number, roomRateList);
        }
    }
    public static void reserveIndividual(Person person){
        Utility.printMessage("RESERVE");
        System.out.println("Number of people to be reserved:");
        int number = sc.nextInt();
    }

    public static void cancelIndividual(Person person, List<RoomRate> roomRateList){
        System.out.println("The maximum occupancy per room is five people.");
        System.out.println("Number of people to be occupied:");
        int number = sc.nextInt();

        if (number > 5){
            distributeMoreFive(person, number);
        }
        else {
            distributeCommon(person, number, roomRateList);
        }
    }
    public static void distributeMoreFive(Person person, int number){
        int result = number % 5;
        if (result == 0) {
            System.out.println("Number of people greater than five.\n" +
                    "however, we can distribute the " + number + "\n" +
                    "people for " +  (number / 5) + " room(s).\n");
        }
        else {
            System.out.println("Number of people greater than five.\n" +
                    "however, we can distribute the " + number + "\n" +
                    "people for " +  ((int)(number / 5) + 1) + " room(s).\n");

        }
    }
    public static void distributeCommon(Person person, int number, List<RoomRate> roomRateList){
        PrivilegeLevel privilegeLevel = person.getPrivilegeLevel();
        sc.nextLine();
        if (number != 1) {
            System.out.println(number + " person can be allocated in a single room,\n" +
                              "but if you wish, you can rent more rooms.\n" +
                              " S/s - single room\n" +
                              " M/m - more rooms\n");
            String option = sc.nextLine();

            switch (option.toLowerCase()){
                case "s" -> {
                    switch(person.getPrivilegeLevel()){
                        case INDIVIDUAL -> {
                            System.out.println("Nice, come on!\n");
                            doOccupancyIndividual(number, 1, roomRateList);
                            break;
                        }
                        case COMPANY -> {
                            System.out.println("Nice, come on!\n");
                            doOccupancyCompany(number, 1, roomRateList);
                            break;
                        }
                    }

                }
                case "m" -> {
                    switch (person.getPrivilegeLevel()) {
                        case INDIVIDUAL -> {
                            System.out.println("Enter number rooms:");
                            int quantityRoom = sc.nextInt();
                            doOccupancyIndividual(number, quantityRoom, roomRateList);
                            break;
                        }
                        case COMPANY -> {
                            System.out.println("Enter number rooms:");
                            int quantityRoom = sc.nextInt();
                            doOccupancyCompany(number, quantityRoom, roomRateList);
                            break;
                        }
                    }
                }
                default -> {
                    Utility.printMessage("Option not existent.\n");
                }
            }

        }
        else {
            switch (person.getPrivilegeLevel()) {
                case INDIVIDUAL -> {
                    doOccupancyIndividual(number, 1, roomRateList);
                    break;
                }
                case COMPANY -> {
                    doOccupancyCompany(number, 1, roomRateList);
                    break;
                }
            }
        }
    }
    public static void doOccupancyIndividual(int number, int roomQuantity, List<RoomRate> roomRateList){
        showRoomSituation();
        Utility.printMessage("Please, choose to room number for the " + number + " people.\n");
        System.out.println("");
        int roomNumber = sc.nextInt();

        Room foundRoom = null;

        for (Room room : getRoomList()){
            if (room.getRoomNumber() == roomNumber && (room.getSituation() == RoomSituation.FREE)){
                foundRoom = room;
                break;
            }
        }
        if (foundRoom != null){
            Utility.printMessage("Room " + roomNumber + " occupatted successfully!\n");
            foundRoom.setSituation(RoomSituation.BUSY);
            Daily.recordDailyIndividual(roomNumber, number, roomRateList);
        }
        else {
            System.out.println("Number not possible.\n");
        }
    }
    public static void doOccupancyCompany(int number, int roomQuantity, List<RoomRate> roomRateList){
        showRoomSituation();
        Utility.printMessage("Please, choose to room number for the " + number + " people.\n");
        System.out.println("");
        int roomNumber = sc.nextInt();

        Room foundRoom = null;

        for (Room room : getRoomList()){
            if (room.getRoomNumber() == roomNumber && room.getSituation() == RoomSituation.FREE){
                foundRoom = room;
                break;
            }
        }
        if (foundRoom != null){
            foundRoom.setSituation(RoomSituation.BUSY);
            Utility.printMessage("Room " + roomNumber + " occupatted successfully!\n");
            Daily.recordDailyCompany(roomNumber, number, roomRateList);
        }
        else {
            System.out.println("Number not possible.\n");
        }
    }
}
