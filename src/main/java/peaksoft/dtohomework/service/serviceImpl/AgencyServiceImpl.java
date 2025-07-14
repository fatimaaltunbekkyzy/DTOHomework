package peaksoft.dtohomework.service.serviceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.dtohomework.dto.SimpleResponse;
import peaksoft.dtohomework.dto.agencyDto.reguest.AgencyRequest;
import peaksoft.dtohomework.dto.agencyDto.reguest.UpdateAgencyRequest;
import peaksoft.dtohomework.dto.agencyDto.response.AgencyResponse;

import peaksoft.dtohomework.dto.houseDto.response.HouseResponse;
import peaksoft.dtohomework.entities.Agency;
import peaksoft.dtohomework.repo.AgencyRepo;
import peaksoft.dtohomework.service.AgencyService;

import java.util.List;

@Service
public class AgencyServiceImpl implements AgencyService {
    private final AgencyRepo agencyRepo;

    public AgencyServiceImpl(AgencyRepo agencyRepo) {
        this.agencyRepo = agencyRepo;
    }

    @Override
    public SimpleResponse save(AgencyRequest agencyRequest) {
        Agency agency = new Agency();
        agency.setName(agencyRequest.name());
        agency.setEmail(agencyRequest.email());
        agency.setPhoneNumber(agencyRequest.phoneNumber());
        agency.setCountry(agencyRequest.country());
        agencyRepo.save(agency);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully saved")
                .build();
    }
    @Override
    public List<AgencyResponse> getAll() {
        return agencyRepo.getAll();

    }
    @Override
    public SimpleResponse update(Long id, UpdateAgencyRequest updateAgencyRequest) {
        Agency agency = agencyRepo.findById(id).orElseThrow(() ->
                new NullPointerException(String.format("Agency with id %d not found", id)));

        agency.setName(updateAgencyRequest.name());
        agency.setCountry(updateAgencyRequest.country());
        agency.setPhoneNumber(updateAgencyRequest.phoneNumber());
        agency.setEmail(updateAgencyRequest.email());

        agencyRepo.save(agency);
return  SimpleResponse
        .builder()
        .httpStatus(HttpStatus.OK)
        .message("Successfully updated")
        .build();
    }

    @Override
    public SimpleResponse delete(Long id) {
        Agency agency = agencyRepo.findById(id).orElseThrow(() ->
                new NullPointerException(String.format("Agency with id %d not found", id)));
        agencyRepo.delete(agency);
        return  SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("Successfully deleted")
                .build();
    }

    @Override
    public List<HouseResponse> getAllHouseByAgencyId(Long agencyId) {
        return agencyRepo.getAllHouseByAgencyId(agencyId);
    }


    @Override
    public AgencyResponse getById(Long id) {
        Agency agency = agencyRepo.findById(id).orElseThrow(() ->
                new NullPointerException(String.format("Agency with id %d not found", id)));

        return new AgencyResponse(
                agency.getId(),
                agency.getName(),
                agency.getCountry(),
                agency.getPhoneNumber(),
                agency.getEmail()
        );

}}
