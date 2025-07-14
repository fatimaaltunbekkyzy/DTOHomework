package peaksoft.dtohomework.dto.houseDto.response;
import lombok.Data;
import lombok.NoArgsConstructor;
import peaksoft.dtohomework.enums.HouseType;

@Data
@NoArgsConstructor
public class HouseResponse {
    private Long id;
    private String address;
    private int price;
    private int room;
    private String country;
    private String description;
    private HouseType houseType;
    private boolean active;

    public HouseResponse(Long id, String address, int price, int room, String country, String description, HouseType houseType, boolean active) {
        this.id = id;
        this.address = address;
        this.price = price;
        this.room = room;
        this.country = country;
        this.description = description;
        this.houseType = houseType;
        this.active = active;
    }
}
