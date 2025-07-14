package peaksoft.dtohomework.service;
import peaksoft.dtohomework.dto.SimpleResponse;
import peaksoft.dtohomework.dto.customerDto.request.CustomerRequest;
import peaksoft.dtohomework.dto.customerDto.request.UpdateCustomerRequest;
import peaksoft.dtohomework.dto.customerDto.response.CustomerResponse;
import peaksoft.dtohomework.entities.Booking;

import java.util.List;


public interface CustomerService {

    SimpleResponse save(CustomerRequest customerRequest);

    List<CustomerResponse> getAll();

    CustomerResponse getById(Long id);

    SimpleResponse update(Long id, UpdateCustomerRequest updateCustomerRequest);

    SimpleResponse delete(Long id);


}
