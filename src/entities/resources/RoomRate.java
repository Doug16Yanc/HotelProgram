package entities.resources;

import enumerations.DailySituation;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class RoomRate {
    private Date dateDaily;
    private Double valueDaily;
    private DailySituation situation;
}
