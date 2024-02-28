package entities.resources;

import entities.persons.Person;
import enumerations.DailySituation;
import enumerations.DailyType;


import java.util.Date;


public class RoomRate {
    private int idDaily;
    private String dateDaily;
    private double valueDaily;
    private int roomNumber;
    private DailySituation situation;

    private DailyType dailyType;

    private Person person;

    public RoomRate(){

    }

    public RoomRate(int idDaily, String dateDaily, double valueDaily, int roomNumber, DailySituation situation, DailyType dailyType, Person person){
        this.idDaily = idDaily;
        this.dateDaily = dateDaily;
        this.valueDaily = valueDaily;
        this.roomNumber = roomNumber;
        this.situation = situation;
        this.dailyType = dailyType;
        this.person = person;
    }

    public int getIdDaily() {
        return idDaily;
    }

    public void setIdDaily(int idDaily) {
        this.idDaily = idDaily;
    }

    public String getDateDaily() {
        return dateDaily;
    }

    public void setDateDaily(String dateDaily) {
        this.dateDaily = dateDaily;
    }

    public double getValueDaily() {
        return valueDaily;
    }

    public void setValueDaily(double valueDaily) {
        this.valueDaily = valueDaily;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public DailySituation getSituation() {
        return situation;
    }

    public void setSituation(DailySituation situation) {
        this.situation = situation;
    }

    public DailyType getDailyType() {
        return dailyType;
    }

    public void setDailyType(DailyType dailyType) {
        this.dailyType = dailyType;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
