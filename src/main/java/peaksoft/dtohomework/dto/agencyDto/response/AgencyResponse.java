package peaksoft.dtohomework.dto.agencyDto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AgencyResponse {
    private Long id;
    private String name;
    private String country;
    private String phoneNumber;
    private String email;

    public AgencyResponse(Long id, String name, String country, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
