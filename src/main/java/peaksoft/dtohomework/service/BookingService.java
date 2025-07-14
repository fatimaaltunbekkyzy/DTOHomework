package peaksoft.dtohomework.service;

import peaksoft.dtohomework.dto.SimpleResponse;
import peaksoft.dtohomework.dto.bookingDto.request.BookingRequest;
import peaksoft.dtohomework.dto.bookingDto.response.BookingResponse;

import java.util.List;

public interface BookingService {
    List<BookingResponse> findAllByCustomerId(Long customerId);

    SimpleResponse save(BookingRequest bookingRequest);
}
