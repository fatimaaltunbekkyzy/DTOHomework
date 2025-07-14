package peaksoft.dtohomework.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="agencies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agency_gen")
    @SequenceGenerator(name = "agency_gen", sequenceName = "agency_seq",allocationSize = 1)

    private Long id;
    private String name;
    private String country;
    private String phoneNumber;
    @Column(unique=true)
    private String email;

    @OneToMany(mappedBy = "agency",cascade = CascadeType.ALL)
    private List<House> houses = new ArrayList<>();

    @ManyToMany
    private List<Customer> customers = new ArrayList<>();

}
