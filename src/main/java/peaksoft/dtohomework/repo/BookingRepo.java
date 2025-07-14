package peaksoft.dtohomework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peaksoft.dtohomework.dto.bookingDto.response.BookingResponse;
import peaksoft.dtohomework.entities.Booking;

import java.util.List;

@Repository
public interface BookingRepo extends JpaRepository<Booking,Long> {
//    @Query("SELECT new peaksoft.dtohomework.dto.bookingDto.response.BookingResponse(b.id, b.house_id, b.customer.name) " +
//            "FROM Booking b WHERE b.customer.id = :customerId")
//    List<BookingResponse> findAllBookingsByCustomerId(@Param("customerId") Long customerId);
}
