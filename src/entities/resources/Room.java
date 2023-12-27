package entities.resources;

import enumerations.RoomSituation;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Room {
    private int roomNumber;
    private RoomSituation situation;
}
