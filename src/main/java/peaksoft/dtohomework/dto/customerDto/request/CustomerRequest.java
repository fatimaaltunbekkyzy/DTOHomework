package peaksoft.dtohomework.dto.customerDto.request;

import peaksoft.dtohomework.enums.Gender;
import java.time.LocalDate;

public record CustomerRequest (
         String name,
         String surname,
         String email,
         Gender gender,
         String phoneNumber,
         LocalDate dateOfBirth
){
}
