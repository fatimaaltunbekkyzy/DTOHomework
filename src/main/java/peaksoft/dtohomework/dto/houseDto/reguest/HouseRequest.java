package peaksoft.dtohomework.dto.houseDto.reguest;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import peaksoft.dtohomework.enums.HouseType;

public record HouseRequest(
        String address,
        int price,
        int room,
        String country,
        String description,
        HouseType houseType,
        boolean active
) {

}
