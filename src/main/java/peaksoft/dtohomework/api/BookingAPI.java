package peaksoft.dtohomework.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dtohomework.dto.SimpleResponse;
import peaksoft.dtohomework.dto.agencyDto.reguest.AgencyRequest;
import peaksoft.dtohomework.dto.bookingDto.request.BookingRequest;
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
    @PostMapping
    SimpleResponse save (@RequestBody BookingRequest bookingRequest) {
        return bookingService.save(bookingRequest);
    }

}
