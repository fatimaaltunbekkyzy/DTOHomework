package peaksoft.dtohomework.dto.bookingDto.request;

public record BookingRequest (
         Long bookingId,
         Long houseId,
         String customerName
){
}
