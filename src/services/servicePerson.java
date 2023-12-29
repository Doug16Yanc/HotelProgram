package services;

import entities.persons.Person;
import utils.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static application.Program.doFirstInteraction;

public class servicePerson {
    static Person person = new Person();
    static Scanner sc = new Scanner(System.in);
    private static final List<Person> personList = new ArrayList<>();
    public static List<Person> getPersonList() {
        return personList;
    }

    public static int generateID() {
        Random random = new Random();
        int enter = random.nextInt(10, 1000000000);

        boolean aux;

        while (true) {
            aux = true;

            for (Person client : personList) {
                if (enter == client.getId()) {
                    aux = false;
                    break;
                }
            }

            if (aux) {
                return enter;
            }
            else {
                enter = random.nextInt(10, 1000000000);
            }
        }
    }
    public static void distinguishPerson(){
        System.out.println("In this way, choose your type so that we can deliver the appropriate services:\n" +
                          "             I/i - Individual          \n" +
                          "             C/c - Company             \n");
        String option = sc.nextLine();

        switch (option.toLowerCase()){
            case "i" -> {
                serviceIndividual.interactsIndividual(person);
            }
            case "c" -> {
                serviceCompany.interactsCompany(person);
            }
            default -> {
                Utility.printMessage("Sorry, however this option´s no-existent.");
                doFirstInteraction();
            }
        }
    }
}
