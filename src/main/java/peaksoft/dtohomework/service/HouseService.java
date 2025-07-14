package peaksoft.dtohomework.service;

import peaksoft.dtohomework.dto.SimpleResponse;
import peaksoft.dtohomework.dto.agencyDto.reguest.UpdateAgencyRequest;
import peaksoft.dtohomework.dto.houseDto.reguest.HouseRequest;
import peaksoft.dtohomework.dto.houseDto.reguest.UpdateHouseRequest;
import peaksoft.dtohomework.dto.houseDto.response.HouseResponse;

import java.util.List;

public interface HouseService {

    SimpleResponse save(Long id, HouseRequest HouseRequest);

    List<HouseResponse> getAll();

    HouseResponse getById(Long id);

    SimpleResponse update(Long id, UpdateHouseRequest updateHouseRequest);

    SimpleResponse delete(Long id);

    List<HouseResponse> getAvailableHouses();
}
