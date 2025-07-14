package peaksoft.dtohomework.service.serviceImpl;

import org.springframework.stereotype.Service;
import peaksoft.dtohomework.dto.bookingDto.response.BookingResponse;
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
}
