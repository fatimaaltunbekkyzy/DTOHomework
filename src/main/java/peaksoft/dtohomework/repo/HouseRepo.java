package peaksoft.dtohomework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peaksoft.dtohomework.dto.customerDto.response.CustomerResponse;
import peaksoft.dtohomework.dto.houseDto.response.HouseResponse;
import peaksoft.dtohomework.entities.House;
import peaksoft.dtohomework.enums.HouseType;

import java.util.List;

@Repository
public interface HouseRepo extends JpaRepository<House,Long> {
    @Query("select new peaksoft.dtohomework.dto.houseDto.response.HouseResponse"
            + "(h.id,h.address,h.price,h.room,h.country,h.description,h.houseType,h.active)FROM House h")
    List<HouseResponse> getAll();

@Query("select new peaksoft.dtohomework.dto.houseDto.response.HouseResponse"
        +"(h.id,h.address,h.price,h.room,h.country,h.description,h.houseType,h.active)FROM House h WHERE h.active = false")
    List<HouseResponse> getHousesIsBooking();

    @Query("SELECT new peaksoft.dtohomework.dto.houseDto.response.HouseResponse(h.id,h.address,h.price,h.room,h.country,h.description,h.houseType,h.active) " +
            "FROM House h " +
            "WHERE (:country IS NULL OR LOWER(h.country) = LOWER(:country)) " +
            "AND (:room IS NULL OR h.room = :room)")
    List<HouseResponse> searchHouses(@Param("country") String country,
                                     @Param("room") Integer room);


}
