package fr.balijon.harrypotter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer yearOfBirth;

    @Column(nullable = false)
    private boolean isAlive;

    @OneToMany(mappedBy = "student")
    private List<OffenseList> offenseLists = new ArrayList<OffenseList>();

    @ManyToMany
    @JoinTable(
            name = "student_type_of_class",
            joinColumns = @JoinColumn(name = "student_id"),  // Column name in the join table for the student
            inverseJoinColumns = @JoinColumn(name = "type_of_class_id")  // Column name for the TypeOfClass
    )
    private List<TypeOfClass> typeOfClasses = new ArrayList<TypeOfClass>();

    @ManyToOne
    @JoinColumn(nullable = false)
    private House house;
}