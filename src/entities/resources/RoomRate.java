package entities.resources;

import enumerations.DailySituation;
import enumerations.DailyType;


import java.util.Date;


public class RoomRate {
    private int idDaily;
    private String dateDaily;
    private double valueDaily;
    private DailySituation situation;

    private DailyType dailyType;

    public RoomRate(){

    }

    public RoomRate(int idDaily, String dateDaily, double valueDaily, DailySituation situation, DailyType dailyType){
        this.idDaily = idDaily;
        this.dateDaily = dateDaily;
        this.valueDaily = valueDaily;
        this.situation = situation;
        this.dailyType = dailyType;
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
}
