package services;

import entities.resources.Room;
import enumerations.OccupancySituation;
import enumerations.RoomSituation;
import utils.Utility;

import java.util.ArrayList;
import java.util.List;

public class Occupancy {
    private static final List<Room> roomList = new ArrayList<>();
    public static List<Room> getRoomList() {
        return roomList;
    }
    public static void initializeRooms(){
        for (int i = 1; i <= 50; i++){
            roomList.add(new Room(i, RoomSituation.FREE));
        }
    }

    public static void showRoomSituation() {
        initializeRooms();
        Utility.printMessage("******SITUATION OF THE ROOMS********\n");
        Utility.printMessage("GREEN - FREE\t RED - BUSY\t BLUE - RESERVED\n\n");

        int maxRoomNumber = 50;
        int roomsPerRow = 5;

        for (int i = 1; i <= maxRoomNumber; i++) {
            Room room = roomList.get(i - 1);

            switch (room.getSituation()) {
                case FREE -> Utility.printGreen("" + room.getRoomNumber());
                case BUSY -> Utility.printRed("" + room.getRoomNumber());
                case RESERVED -> Utility.printBlue("" + room.getRoomNumber());
            }
            if (i % roomsPerRow == 0) {
                System.out.println("\t\n");
            }
        }
    }

    /*

    public static void showRoomSituation(){
        initializeRooms();
        Utility.printMessage("******SITUATION OF THE ROOMS********\n");
        Utility.printMessage("GREEN - FREE\t RED - BUSY\t BLUE - RESERVED\n\n");

        List<Room> evenRooms = new ArrayList<>();
        List<Room> oddRooms = new ArrayList<>();

        for (Room room : roomList) {
            if (room.getRoomNumber() % 2 == 0) {
                evenRooms.add(room);
            } else {
                oddRooms.add(room);
            }
        }
        int maxCount = Math.max(evenRooms.size(), oddRooms.size());
        for (int i = 0; i < maxCount; i++) {
            if (i < evenRooms.size()) {
                System.out.println("\t");
                Room evenRoom = evenRooms.get(i);
                switch (evenRoom.getSituation()) {
                    case FREE -> Utility.preentGreen("" + evenRoom.getRoomNumber());
                    case BUSY -> Utility.printRed("" + evenRoom.getRoomNumber());
                    case RESERVED -> Utility.printBlue("" + evenRoom.getRoomNumber());
                }
            }
            if (i < oddRooms.size()) {
                Room oddRoom = oddRooms.get(i);
                switch (oddRoom.getSituation()) {
                    case FREE -> Utility.preentGreen("" + oddRoom.getRoomNumber());
                    case BUSY -> Utility.printRed("" + oddRoom.getRoomNumber());
                    case RESERVED -> Utility.printBlue("" + oddRoom.getRoomNumber());
                }
            }
        } */

}
