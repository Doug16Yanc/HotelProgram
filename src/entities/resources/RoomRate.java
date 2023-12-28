package entities.resources;

import enumerations.DailySituation;


import java.util.Date;


public class RoomRate {
    private Date dateDaily;
    private Double valueDaily;
    private DailySituation situation;

    public RoomRate(Date dateDaily, Double valueDaily, DailySituation situation){
        this.dateDaily = dateDaily;
        this.valueDaily = valueDaily;
        this.situation = situation;
    }

    public Date getDateDaily() {
        return dateDaily;
    }

    public void setDateDaily(Date dateDaily) {
        this.dateDaily = dateDaily;
    }

    public Double getValueDaily() {
        return valueDaily;
    }

    public void setValueDaily(Double valueDaily) {
        this.valueDaily = valueDaily;
    }

    public DailySituation getSituation() {
        return situation;
    }

    public void setSituation(DailySituation situation) {
        this.situation = situation;
    }
}
