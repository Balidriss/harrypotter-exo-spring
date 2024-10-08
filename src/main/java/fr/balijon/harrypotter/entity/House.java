package fr.balijon.harrypotter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String houseName;

    @Column(nullable = false)
    private String founderFirstName;

    @Column(nullable = false)
    private String founderLastName;

    @OneToMany(mappedBy = "house")
    private List<Student> students;

    @OneToMany(mappedBy = "house")
    private List<HousePoint> housePoints;

}