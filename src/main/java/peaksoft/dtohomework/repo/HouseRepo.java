package peaksoft.dtohomework.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import peaksoft.dtohomework.dto.houseDto.response.HouseResponse;
import peaksoft.dtohomework.entities.House;

import java.util.List;

@Repository
public interface HouseRepo extends JpaRepository<House,Long> {
//    @Query("select new peaksoft.dtohomework.dto.houseDto.response.HouseResponse(" +
//            "h.id, h.address, h.price, h.room, h.country, h.description, h.houseType, h.active, h.agency.id, h.agency.name,a)" +
//            "from House h")
//    List<HouseResponse> getAll();
}
