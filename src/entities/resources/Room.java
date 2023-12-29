package entities.resources;

import enumerations.RoomSituation;

public class Room {
    private int roomNumber;
    private RoomSituation situation;

    public Room(){

    }
    public Room(int roomNumber, RoomSituation situation){
        this.roomNumber = roomNumber;
        this.situation = situation;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomSituation getSituation() {
        return situation;
    }

    public void setSituation(RoomSituation situation) {
        this.situation = situation;
    }
}
