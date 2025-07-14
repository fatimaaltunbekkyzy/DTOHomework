package peaksoft.dtohomework.service;

import peaksoft.dtohomework.dto.SimpleResponse;
import peaksoft.dtohomework.dto.agencyDto.reguest.AgencyRequest;
import peaksoft.dtohomework.dto.agencyDto.reguest.UpdateAgencyRequest;
import peaksoft.dtohomework.dto.agencyDto.response.AgencyResponse;
import peaksoft.dtohomework.dto.houseDto.response.HouseResponse;

import java.util.List;

public interface AgencyService {

    SimpleResponse save(AgencyRequest agencyRequest);

    List<AgencyResponse> getAll();

    AgencyResponse getById(Long id);

    SimpleResponse update(Long id, UpdateAgencyRequest updateAgencyRequest);

    SimpleResponse delete(Long id);

    List<HouseResponse> getAllHouseByAgencyId(Long agencyId);



}
