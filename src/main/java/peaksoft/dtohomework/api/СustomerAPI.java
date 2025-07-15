package peaksoft.dtohomework.api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dtohomework.dto.SimpleResponse;
import peaksoft.dtohomework.dto.customerDto.request.CustomerRequest;
import peaksoft.dtohomework.dto.customerDto.request.UpdateCustomerRequest;
import peaksoft.dtohomework.dto.customerDto.response.CustomerResponse;
import peaksoft.dtohomework.dto.customerDto.response.CustomerResponseSearch;
import peaksoft.dtohomework.service.CustomerService;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class СustomerAPI {

    private final CustomerService customerService;

    @PostMapping("/save")
    SimpleResponse save (@RequestBody CustomerRequest customerRequest) {
        return customerService.save(customerRequest);
    }

    @GetMapping
    public List<CustomerResponse> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public CustomerResponse getById(@PathVariable Long id) {
        return customerService.getById(id);
    }

    @PutMapping("/{id}")
    public SimpleResponse update (@PathVariable Long id, @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return customerService.update(id,updateCustomerRequest);
    }

    @DeleteMapping("/{id}")
    public SimpleResponse delete (@PathVariable Long id) {
        return customerService.delete(id);
    }

    @GetMapping("/search")
    public List<CustomerResponseSearch> searchCustomers(@RequestParam String name) {
        return customerService.searchCustomers(name);
    }}
