package peaksoft.dtohomework.service;

import peaksoft.dtohomework.dto.bookingDto.response.BookingResponse;

import java.util.List;

public interface BookingService {
    List<BookingResponse> findAllByCustomerId(Long customerId);

}
