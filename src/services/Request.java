package services;

import entities.persons.Person;
import entities.resources.Room;
import enumerations.RoomSituation;
import jdk.jshell.execution.Util;
import utils.Utility;

import java.util.Scanner;

import static services.Occupancy.*;

public class Request {

    static Scanner sc = new Scanner(System.in);

    public static void occupiesCompany(Person person){
        Utility.printMessage("OCCUPANCY");
        System.out.println("The maximum occupancy per room is five people.");
        System.out.println("Number of people to be occupied:");
        int number = sc.nextInt();

        if (number > 5){
           distributeMoreFive(number);
        }
        else {
            distributeCommon(number);
        }

    }

    public static void reserveCompany(Person person){
        Utility.printMessage("RESERVE");
        System.out.println("Number of people to be reserved:");
        int number = sc.nextInt();
    }
    public static void cancelCompany(Person person){

    }
    public static void occupiesIndividual(Person person){
        Utility.printMessage("OCCUPANCY");
        System.out.println("Number of people to be occupied:");
        int number = sc.nextInt();
    }
    public static void reserveIndividual(Person person){
        Utility.printMessage("RESERVE");
        System.out.println("Number of people to be reserved:");
        int number = sc.nextInt();
    }

    public static void cancelIndividual(Person person){
        System.out.println("The maximum occupancy per room is five people.");
        System.out.println("Number of people to be occupied:");
        int number = sc.nextInt();

        if (number > 5){
            distributeMoreFive(number);
        }
        else {
            distributeCommon(number);
        }
    }
    public static void distributeMoreFive(int number){
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
    public static void distributeCommon(int number){
        sc.nextLine();
        if (number != 1) {
            System.out.println(number + " person can be allocated in a single room,\n" +
                              "but if you wish, you can rent more rooms.\n" +
                              " S/s - single room\n" +
                              " M/m - more rooms\n");
            String option = sc.nextLine();

            switch (option.toLowerCase()){
                case "s" -> {
                    System.out.println("Nice, come on!\n");
                    doOccupancy(number, 1);
                }
                case "m" -> {
                    System.out.println("Enter number rooms:");
                    int quantityRoom = sc.nextInt();
                    doOccupancy(number, quantityRoom);
                }
                default -> {
                    Utility.printMessage("Option not existent.\n");
                }
            }

        }
        else {
            doOccupancy(number, 1);
        }
    }
    public static void doOccupancy(int number, int roomQuantity){
        showRoomSituation();
        Utility.printMessage("Please, choose to room number for the " + number + " people.\n");
        System.out.println("");
        int roomNumber = sc.nextInt();

        Room foundRoom = null;

        for (Room room : getRoomList()){
            if (room.getRoomNumber() == roomNumber && (room.getSituation() != RoomSituation.BUSY && room.getSituation() != RoomSituation.RESERVED)){
                foundRoom = room;
                break;
            }
        }
        if (foundRoom != null){
            System.out.println("Room " + roomNumber + " occupatted successfully!\n");
        }
        else {
            System.out.println("Number not possible.\n");
        }
    }
}
