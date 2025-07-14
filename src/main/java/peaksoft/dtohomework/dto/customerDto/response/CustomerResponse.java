package peaksoft.dtohomework.dto.customerDto.response;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import peaksoft.dtohomework.enums.Gender;

import java.time.LocalDate;

@Data
@NoArgsConstructor

public class CustomerResponse {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Gender gender;
    private String phoneNumber;
    private LocalDate dateOfBirth;

    public CustomerResponse(Long id, String name, String surname, String email, Gender gender, String phoneNumber, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }
}
