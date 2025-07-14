package peaksoft.dtohomework.dto.houseDto.reguest;

public record UpdateHouseRequest(
        int price,
        String description,
        boolean active
) {
}
