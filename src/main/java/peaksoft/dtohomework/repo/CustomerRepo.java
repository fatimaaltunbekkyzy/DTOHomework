package peaksoft.dtohomework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import peaksoft.dtohomework.dto.customerDto.response.CustomerResponse;
import peaksoft.dtohomework.entities.Customer;

import java.util.List;

@Repository
public interface CustomerRepo  extends JpaRepository<Customer,Long> {
    @Query("select new peaksoft.dtohomework.dto.customerDto.response.CustomerResponse"
            + "(c.id,c.name,c.surname,c.email,c.gender,c.phoneNumber,c.dateOfBirth)FROM Customer c")
    List<CustomerResponse> getAll();
}
