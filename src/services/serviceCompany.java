package services;

import entities.persons.Person;

import java.util.List;
import java.util.Random;

public class serviceCompany {
    private static int gerarID(List<Person> personList) {
        Random random = new Random();
        int enter = random.nextInt(100000, 1000000);

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
                enter = random.nextInt(100000, 1000000);
            }
        }
    }
    public static void interactsCompany(List<Person> personList){
        gerarID(personList);
    }
}
