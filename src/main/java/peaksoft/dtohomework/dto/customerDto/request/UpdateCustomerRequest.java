package peaksoft.dtohomework.dto.customerDto.request;

import jakarta.persistence.Column;
import peaksoft.dtohomework.enums.Gender;

import java.time.LocalDate;

public record UpdateCustomerRequest (
        String name,
        String surname,
        @Column(unique=true)
        String email,
        Gender gender,
        String phoneNumber,
        LocalDate dateOfBirth
){
}
