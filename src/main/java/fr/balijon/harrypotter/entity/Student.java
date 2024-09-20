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
    private LocalDate yearOfBirth;

    @Column(nullable = false)
    private boolean isAlive;

    @ManyToMany
    @JoinTable(name = "student_type_of_class")
    private List<TypeOfClass> typeOfClasses = new ArrayList<TypeOfClass>();

    @ManyToOne
    @JoinColumn(nullable = false)
    private House house;
}