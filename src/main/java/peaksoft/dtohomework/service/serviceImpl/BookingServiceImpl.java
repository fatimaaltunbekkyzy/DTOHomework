package peaksoft.dtohomework.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dtohomework.dto.SimpleResponse;
import peaksoft.dtohomework.dto.bookingDto.request.BookingRequest;
import peaksoft.dtohomework.dto.bookingDto.response.BookingResponse;
import peaksoft.dtohomework.entities.Agency;
import peaksoft.dtohomework.entities.Booking;
import peaksoft.dtohomework.entities.Customer;
import peaksoft.dtohomework.entities.House;
import peaksoft.dtohomework.repo.BookingRepo;
import peaksoft.dtohomework.repo.CustomerRepo;
import peaksoft.dtohomework.repo.HouseRepo;
import peaksoft.dtohomework.service.BookingService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    @Override
    public List<BookingResponse> findAllByCustomerId(Long customerId) {
        return null;
//        return bookingRepo.findAllBookingsByCustomerId(customerId);
    }

    @Override
    public SimpleResponse save(BookingRequest bookingRequest) {
       return null;

}

    @Override
    public List<BookingResponse> getTotalBookingsByCustomer(Long customerId) {
        return List.of();
    }
}
