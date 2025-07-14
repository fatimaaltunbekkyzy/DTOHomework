package peaksoft.dtohomework.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import peaksoft.dtohomework.dto.SimpleResponse;
import peaksoft.dtohomework.dto.agencyDto.reguest.AgencyRequest;
import peaksoft.dtohomework.dto.agencyDto.reguest.UpdateAgencyRequest;
import peaksoft.dtohomework.dto.agencyDto.response.AgencyResponse;
import peaksoft.dtohomework.dto.houseDto.response.HouseResponse;
import peaksoft.dtohomework.service.AgencyService;

import java.util.List;

@RestController
@RequestMapping("/api/agency")
@RequiredArgsConstructor
public class AgencyAPI {
private final AgencyService agencyService;

     @PostMapping
     SimpleResponse save (@RequestBody AgencyRequest agencyRequest) {
     return agencyService.save(agencyRequest);
    }

    @GetMapping
    public List<AgencyResponse> getAll(){
        return agencyService.getAll();
    }

    @GetMapping("/{id}")
    public AgencyResponse getById(@PathVariable Long id) {
        return agencyService.getById(id);
    }

    @PutMapping("/{id}")
    public SimpleResponse update (@PathVariable Long id, @RequestBody UpdateAgencyRequest updateAgencyRequest) {
        return agencyService.update(id, updateAgencyRequest);
    }

    @DeleteMapping("/{id}")
    public SimpleResponse delete (@PathVariable Long id) {
    return agencyService.delete(id);
    }

    @GetMapping("/{agencyId}/house")
    public List<HouseResponse>getAllHouseByAgencyId(@PathVariable Long agencyId) {
         return agencyService.getAllHouseByAgencyId(agencyId);
}}
