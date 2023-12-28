package services;

import entities.persons.Person;
import entities.resources.RoomRate;

import java.util.List;
import java.util.Random;

public class Daily {
    private static int gerarID(List<RoomRate> dailyList) {
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
}
