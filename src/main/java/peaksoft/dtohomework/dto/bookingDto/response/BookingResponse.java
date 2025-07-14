package peaksoft.dtohomework.dto.bookingDto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookingResponse {
    private Long id;
    private Long house_id;
    private String name;

    public BookingResponse(Long id, Long house_id, String name) {
        this.id = id;
        this.house_id = house_id;
        this.name = name;
    }
}
