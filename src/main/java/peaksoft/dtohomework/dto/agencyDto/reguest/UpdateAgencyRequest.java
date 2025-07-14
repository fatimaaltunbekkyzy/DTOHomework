package peaksoft.dtohomework.dto.agencyDto.reguest;

public record UpdateAgencyRequest(
        String name,
        String country,
        String phoneNumber,
        String email
) {
}
