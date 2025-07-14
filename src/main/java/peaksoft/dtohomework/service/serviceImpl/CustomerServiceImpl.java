package peaksoft.dtohomework.service.serviceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dtohomework.dto.SimpleResponse;
import peaksoft.dtohomework.dto.customerDto.request.CustomerRequest;
import peaksoft.dtohomework.dto.customerDto.request.UpdateCustomerRequest;
import peaksoft.dtohomework.dto.customerDto.response.CustomerResponse;
import peaksoft.dtohomework.entities.Customer;
import peaksoft.dtohomework.repo.CustomerRepo;
import peaksoft.dtohomework.service.CustomerService;
import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public SimpleResponse save(CustomerRequest customerRequest) {

        if (!customerRequest.phoneNumber().matches("^\\+996\\d{9}$")){
            throw new IllegalArgumentException("Phone number is incorrect");
        }

        Customer customer = new Customer();
        customer.setName(customerRequest.name());
        customer.setSurname(customerRequest.surname());
        customer.setPhoneNumber(customerRequest.phoneNumber());
        customer.setEmail(customerRequest.email());
        customer.setGender(customerRequest.gender());
        customer.setDateOfBirth(customerRequest.dateOfBirth());
        customerRepo.save(customer);

        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully saved")
                .build();
    }

    @Override
    public List<CustomerResponse> getAll() {
        return customerRepo.getAll();
    }

    @Override
    public CustomerResponse getById(Long id) {
        Customer customer = customerRepo.findById(id).orElseThrow(() ->
                new NullPointerException(String.format("Customer with id %d not found", id)));

        return new CustomerResponse(
                customer.getId(),
                customer.getName(),
                customer.getSurname(),
                customer.getEmail(),
                customer.getGender(),
                customer.getPhoneNumber(),
                customer.getDateOfBirth()
        );
    }

    @Override
    public SimpleResponse update(Long id, UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = customerRepo.findById(id).orElseThrow(() ->
                new NullPointerException(String.format("Customer with id %d not found", id)));

        customer.setName(updateCustomerRequest.name());
        customer.setSurname(updateCustomerRequest.surname());
        customer.setEmail(updateCustomerRequest.email());
        customer.setGender(updateCustomerRequest.gender());
        customer.setPhoneNumber(updateCustomerRequest.phoneNumber());
        customer.setDateOfBirth(updateCustomerRequest.dateOfBirth());

        customerRepo.save(customer);
        return  SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully updated")
                .build();
    }

    @Override
    public SimpleResponse delete(Long id) {
        Customer customer = customerRepo.findById(id).orElseThrow(() ->
                new NullPointerException(String.format("Customer with id %d not found", id)));
        customerRepo.delete(customer);
        return  SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully deleted")
                .build();
    }
}
