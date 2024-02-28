package services;

import entities.persons.Company;
import entities.persons.Individual;
import entities.persons.Person;
import entities.resources.RoomRate;
import enumerations.DailyType;
import utils.Utility;

import java.util.List;

import static utils.Utility.printMessage;

public class Query {


    public static void queryOccupancyCompany(Company company, List<RoomRate> roomRateList){
        printMessage("******QUERY OCCUPANCY COMPANY********\n");
        if (!roomRateList.isEmpty()){
            for (RoomRate roomRate : roomRateList) {
                if(roomRate.getDailyType() == DailyType.OCCUPANCY){
                    System.out.println("            INDIVIDUAL DATA         \n\n" +
                            "             > Name : " + roomRate.getPerson().getName() + "\n" +
                            "             > Id : " + roomRate.getPerson().getId() + "\n" +
                            "             > Address : " + roomRate.getPerson().getAddress() + "\n" +
                            "             > Email : " + roomRate.getPerson().getEmail() + "\n" +
                            "             > Origin : " + roomRate.getPerson().getOrigin() + "\n" +
                            "             > Client type : " + company.getPrivilegeLevel() + "\n\n" +
                            "             ROOM DATA       \n\n" +
                            "             OCCUPANCY DATA                    \n\n" +
                            "             > Id occupancy : " + roomRate.getIdDaily() + "\n" +
                            "             > Date : " + roomRate.getDateDaily()+ "\n");
                }
            }
        }
        else{
            printMessage("No occupancy requests.\n");
        }
    }
    public static void queryOccupancyIndividual(Individual individual, List<RoomRate> roomRateList){
        printMessage("******QUERY OCCUPANCY INDIVIDUAL********\n");
        if (!roomRateList.isEmpty()){
            for (RoomRate roomRate : roomRateList) {
                if(roomRate.getDailyType() == DailyType.OCCUPANCY){
                    System.out.println("            INDIVIDUAL DATA         \n\n" +
                            "             > Name : " + roomRate.getPerson().getName() + "\n" +
                            "             > Id : " + roomRate.getPerson().getId() + "\n" +
                            "             > Address : " + roomRate.getPerson().getAddress() + "\n" +
                            "             > Email : " + roomRate.getPerson().getEmail() + "\n" +
                            "             > Origin : " + roomRate.getPerson().getOrigin() + "\n" +
                            "             > Client type : " + roomRate.getPerson().getPrivilegeLevel() + "\n\n" +
                            "             ROOM DATA       \n\n" +
                            "             OCCUPANCY DATA                    \n\n" +
                            "             > Id occupancy : " + roomRate.getIdDaily() + "\n" +
                            "             > Date : " + roomRate.getDateDaily()+ "\n" +
                            "             > Value of daily : " + roomRate.getValueDaily());
                }
            }
        }
        else{
            printMessage("No occupancy requests.\n");
        }
    }
    public static void queryReserveCompany(Person person){

    }
    public static void queryReserveIndividual(Person person){

    }
    public static void queryCancellationCompany(Person person){

    }
    public static void queryCancellationIndividual(Person person){

    }
}
