package peaksoft.dtohomework.service.serviceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dtohomework.dto.SimpleResponse;
import peaksoft.dtohomework.dto.bookingDto.request.BookingRequest;
import peaksoft.dtohomework.dto.bookingDto.response.BookingResponse;
import peaksoft.dtohomework.entities.Agency;
import peaksoft.dtohomework.entities.Booking;
import peaksoft.dtohomework.repo.BookingRepo;
import peaksoft.dtohomework.service.BookingService;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepo bookingRepo;

    public BookingServiceImpl(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    @Override
    public List<BookingResponse> findAllByCustomerId(Long customerId) {
        return null;
//        return bookingRepo.findAllBookingsByCustomerId(customerId);
    }

    @Override
    public SimpleResponse save(BookingRequest bookingRequest) {
        Booking booking = new Booking();
        booking.setId(bookingRequest.bookingId());

        bookingRepo.save(booking);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully saved")
                .build();

    }
}
