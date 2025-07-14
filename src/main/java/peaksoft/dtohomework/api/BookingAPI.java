package peaksoft.dtohomework.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peaksoft.dtohomework.dto.bookingDto.response.BookingResponse;
import peaksoft.dtohomework.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
@RequiredArgsConstructor
public class BookingAPI {
    private final BookingService bookingService;

    @GetMapping("/customer/{id}")
    public List<BookingResponse> getBookingsByCustomer(@PathVariable Long id) {
        return bookingService.findAllByCustomerId(id);
    }
}
