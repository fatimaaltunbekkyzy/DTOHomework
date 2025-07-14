package peaksoft.dtohomework.service.serviceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dtohomework.dto.SimpleResponse;
import peaksoft.dtohomework.dto.agencyDto.reguest.UpdateAgencyRequest;
import peaksoft.dtohomework.dto.agencyDto.response.AgencyResponse;
import peaksoft.dtohomework.dto.houseDto.reguest.HouseRequest;
import peaksoft.dtohomework.dto.houseDto.reguest.UpdateHouseRequest;
import peaksoft.dtohomework.dto.houseDto.response.HouseResponse;
import peaksoft.dtohomework.entities.Agency;
import peaksoft.dtohomework.entities.House;
import peaksoft.dtohomework.repo.AgencyRepo;
import peaksoft.dtohomework.repo.HouseRepo;
import peaksoft.dtohomework.service.HouseService;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    private final HouseRepo houseRepo;
private final AgencyRepo agencyRepo;

    public HouseServiceImpl(HouseRepo houseRepo, AgencyRepo agencyRepo) {
        this.houseRepo = houseRepo;
        this.agencyRepo = agencyRepo;

}

    @Override
    public SimpleResponse save(Long id, HouseRequest houseRequest) {
        Agency agency = agencyRepo.findById(id)
                .orElseThrow(() -> new NullPointerException("Agency not found with id: " +id));
        House house = new House();
        house.setAddress(houseRequest.address());
        house.setPrice(houseRequest.price());
        house.setRoom(houseRequest.room());
        house.setCountry(houseRequest.country());
        house.setDescription(houseRequest.description());
        house.setHouseType(houseRequest.houseType());
        house.setActive(houseRequest.active());
        house.setAgency(agency);
        agency.getHouses().add(house);
        houseRepo.save(house);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("SuccessFully saved House")
                .build();

    }

    @Override
    public List<HouseResponse> getAll() {
        return houseRepo.getAll();
    }

    @Override
    public HouseResponse getById(Long id) {
        House house = houseRepo.findById(id).orElseThrow(() ->
                new NullPointerException(String.format("House with id %d not found", id)));

        return new HouseResponse(
                house.getId(),
                house.getAddress(),
                house.getPrice(),
                house.getRoom(),
                house.getCountry(),
                house.getDescription(),
                house.getHouseType(),
                house.isActive()
        );
    }

    @Override
    public SimpleResponse update(Long id, UpdateHouseRequest updateHouseRequest) {
        House house = houseRepo.findById(id).orElseThrow(() ->
                new NullPointerException(String.format("House with id %d not found", id)));

        house.setPrice(updateHouseRequest.price());
        house.setDescription(updateHouseRequest.description());
        house.setActive(updateHouseRequest.active());
        houseRepo.save(house);
        return  SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully updated")
                .build();
    }

    @Override
    public SimpleResponse delete(Long id) {
        House house = houseRepo.findById(id).orElseThrow(() ->
                new NullPointerException(String.format("House with id %d not found", id)));
        houseRepo.delete(house);
        return  SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully deleted")
                .build();

    }

    @Override
    public List<HouseResponse> getHousesIsBooking() {
        return houseRepo.getHousesIsBooking();

}}
