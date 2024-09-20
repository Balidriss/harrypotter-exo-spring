package fr.balijon.harrypotter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class TypeOfClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer yearTaught;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Subject subject;

    @ManyToMany(mappedBy = "typeOfClasses")
    private List<Student> students = new ArrayList<Student>();
}