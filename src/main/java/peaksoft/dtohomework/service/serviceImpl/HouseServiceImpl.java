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
        List<House> all = houseRepo.findAll();
        List<HouseResponse> houseResponseList = new ArrayList<>();

        for (House house : all) {
            Agency agency = house.getAgency();

            AgencyResponse agencyResponse = new AgencyResponse(
                    agency.getId(),
                    agency.getName(),
                    agency.getCountry(),
                    agency.getEmail(),
                    agency.getPhoneNumber()
            );

            HouseResponse houseResponse = new HouseResponse();
            houseResponse.setId(house.getId());
            houseResponse.setHouseType(house.getHouseType());
            houseResponse.setAddress(house.getAddress());
            houseResponse.setCountry(house.getCountry());
            houseResponse.setActive(house.isActive());
            houseResponse.setRoom(house.getRoom());
            houseResponse.setPrice(house.getPrice());
            houseResponse.setDescription(house.getDescription());
//            houseResponse.setAgency(agencyResponse);

            houseResponseList.add(houseResponse);
        }

        return houseResponseList;
    }

    @Override
    public HouseResponse getById(Long id) {
        House house = houseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("House not found with id: " + id));

        Agency agency = house.getAgency();

        AgencyResponse agencyResponse = new AgencyResponse(
                agency.getId(),
                agency.getName(),
                agency.getCountry(),
                agency.getEmail(),
                agency.getPhoneNumber()
        );

        HouseResponse houseResponse = new HouseResponse();
        houseResponse.setId(house.getId());
        houseResponse.setAddress(house.getAddress());
        houseResponse.setPrice(house.getPrice());
        houseResponse.setRoom(house.getRoom());
        houseResponse.setCountry(house.getCountry());
        houseResponse.setDescription(house.getDescription());
        houseResponse.setHouseType(house.getHouseType());
        houseResponse.setActive(house.isActive());
//        houseResponse.setAgency(agencyResponse);

        return houseResponse;
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
    public List<HouseResponse> getAvailableHouses() {
        return List.of();
    }
}
