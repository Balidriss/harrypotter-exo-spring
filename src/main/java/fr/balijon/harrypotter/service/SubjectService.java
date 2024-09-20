package fr.balijon.harrypotter.service;

import fr.balijon.harrypotter.entity.Subject;
import fr.balijon.harrypotter.repositories.SubjectRepository;
import fr.balijon.harrypotter.service.interfaces.ServiceListInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectService implements ServiceListInterface<Subject, Integer, Subject, Subject> {

    SubjectRepository subjectRepository;

    @Override
    public List<Subject> list() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject create(Subject o) {
        return subjectRepository.saveAndFlush(o);
    }

    @Override
    public Subject update(Subject o, Integer id) {
        Subject newO = subjectRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        newO.setId(id);
        newO.setSubjectName(o.getSubjectName());
        return subjectRepository.saveAndFlush(newO);
    }

    @Override
    public void delete(Subject o) {
        subjectRepository.delete(o);
    }

    @Override
    public Subject findOneById(Integer id) {
        return subjectRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
