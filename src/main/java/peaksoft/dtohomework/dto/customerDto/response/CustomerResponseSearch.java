package peaksoft.dtohomework.dto.customerDto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import peaksoft.dtohomework.enums.Gender;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CustomerResponseSearch {
    private Long id;
    private String name;
    private String email;
    private Gender gender;
    private String phoneNumber;
    private LocalDate dateOfBirth;

    public CustomerResponseSearch(Long id, String name, String email, Gender gender, String phoneNumber, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }
}
