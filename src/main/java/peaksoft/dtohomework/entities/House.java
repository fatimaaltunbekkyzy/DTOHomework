package peaksoft.dtohomework.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import peaksoft.dtohomework.enums.HouseType;

@Entity
@Table(name="houses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "house_gen")
    @SequenceGenerator(name = "house_gen", sequenceName = "house_seq",allocationSize = 1)

    private Long id;
    private String address;
    private int price;
    private int room;
    private String country;
    private String description;
    @Enumerated(EnumType.STRING)
    private HouseType houseType;
    private boolean active;

    @ManyToOne(fetch = FetchType.EAGER)
    private Agency agency;

    @OneToOne(mappedBy = "house", cascade = CascadeType.ALL)
    private Booking booking;
}
