package peaksoft.dtohomework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import peaksoft.dtohomework.dto.agencyDto.response.AgencyResponse;
import peaksoft.dtohomework.dto.houseDto.response.HouseResponse;
import peaksoft.dtohomework.entities.Agency;

import java.util.List;

@Repository
public interface AgencyRepo extends JpaRepository<Agency,Long> {
    @Query("select new peaksoft.dtohomework.dto.agencyDto.response.AgencyResponse" + "(a.id,a.country,a.email,a.name,a.phoneNumber)FROM Agency a")
    List<AgencyResponse> getAll();

    @Query("select new peaksoft.dtohomework.dto.houseDto.response.HouseResponse(" +
            "h.id, h.address, h.price, h.room, h.country, h.description, h.houseType, h.active) " +
            "FROM House h WHERE h.agency.id = :agencyId")
//    @Query("select new peaksoft.dtohomework.dto.houseDto.response.HouseResponse"+"(h.id,h.address,h.price,h.room,h.country,h.description,h.houseType,h.active)" +
//            "FROM House h WHERE h.agency.id = :id")
    List<HouseResponse> getAllHouseByAgencyId(@PathVariable("agencyId") Long agencyId);
}
