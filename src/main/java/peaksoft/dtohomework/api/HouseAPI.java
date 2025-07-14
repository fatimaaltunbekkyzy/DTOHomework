package peaksoft.dtohomework.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import peaksoft.dtohomework.dto.SimpleResponse;
import peaksoft.dtohomework.dto.houseDto.reguest.HouseRequest;
import peaksoft.dtohomework.dto.houseDto.reguest.UpdateHouseRequest;
import peaksoft.dtohomework.dto.houseDto.response.HouseResponse;
import peaksoft.dtohomework.service.HouseService;

import java.util.List;

@RestController
@RequestMapping("/api/house")
@RequiredArgsConstructor
public class HouseAPI {
    private final HouseService houseService;

    @PostMapping("{id}")
    public SimpleResponse save(@PathVariable Long id, @RequestBody HouseRequest houseRequest) {
        return houseService.save(id, houseRequest);
    }
    @GetMapping("/agency/{id}")
    public List<HouseResponse> getHousesByAgencyId(@PathVariable Long id) {
        return houseService.getAll();
    }
    @GetMapping("/{id}")
    public HouseResponse getById(@PathVariable Long id) {
        return houseService.getById(id);
    }
    @PutMapping("/{id}")
    public SimpleResponse update (@PathVariable Long id, @RequestBody UpdateHouseRequest updateHouseRequest) {
        return houseService.update(id, updateHouseRequest);
    }

    @DeleteMapping("/{id}")
    public SimpleResponse delete (@PathVariable Long id) {
        return houseService.delete(id);
    }

    @GetMapping("/available")
    public List<HouseResponse> getAvailableHouses() {
        return houseService.getHousesIsBooking();
    }
}