package fr.balijon.harrypotter.service;

import fr.balijon.harrypotter.entity.Student;
import fr.balijon.harrypotter.repositories.StudentRepository;
import fr.balijon.harrypotter.service.interfaces.ServiceListInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService implements ServiceListInterface<Student, Integer, Student, Student> {

    StudentRepository studentRepository;

    @Override
    public List<Student> list() {
        return studentRepository.findAll();
    }

    @Override
    public Student create(Student o) {
        return studentRepository.saveAndFlush(o);
    }

    @Override
    public Student update(Student o, Integer id) {
        Student newO = studentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        newO.setId(id);
        newO.setAlive(o.isAlive());
        newO.setHouse(o.getHouse());
        newO.setName(o.getName());
        newO.setYearOfBirth(o.getYearOfBirth());
        newO.setTypeOfClasses(o.getTypeOfClasses());
        return studentRepository.saveAndFlush(newO);
    }

    @Override
    public void delete(Student o) {
        studentRepository.delete(o);
    }

    @Override
    public Student findOneById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
