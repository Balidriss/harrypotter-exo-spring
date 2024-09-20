package fr.balijon.harrypotter.service;

import fr.balijon.harrypotter.entity.Teacher;
import fr.balijon.harrypotter.repositories.TeacherRepository;
import fr.balijon.harrypotter.service.interfaces.ServiceListInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService implements ServiceListInterface<Teacher, Integer, Teacher, Teacher> {

    TeacherRepository teacherRepository;

    @Override
    public List<Teacher> list() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher create(Teacher o) {
        return teacherRepository.saveAndFlush(o);
    }

    @Override
    public Teacher update(Teacher o, Integer id) {
        Teacher newO = teacherRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        newO.setId(id);
        newO.setName(o.getName());
        return teacherRepository.saveAndFlush(newO);
    }

    @Override
    public void delete(Teacher o) {
        teacherRepository.delete(o);
    }

    @Override
    public Teacher findOneById(Integer id) {
        return teacherRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
