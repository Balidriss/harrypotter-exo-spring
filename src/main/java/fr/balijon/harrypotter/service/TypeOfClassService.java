package fr.balijon.harrypotter.service;

import fr.balijon.harrypotter.entity.TypeOfClass;
import fr.balijon.harrypotter.repositories.TypeOfClassRepository;
import fr.balijon.harrypotter.service.interfaces.ServiceListInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TypeOfClassService implements ServiceListInterface<TypeOfClass, Integer, TypeOfClass, TypeOfClass> {

    TypeOfClassRepository typeOfClassRepository;

    @Override
    public List<TypeOfClass> list() {
        return typeOfClassRepository.findAll();
    }

    @Override
    public TypeOfClass create(TypeOfClass o) {
        return typeOfClassRepository.saveAndFlush(o);
    }

    @Override
    public TypeOfClass update(TypeOfClass o, Integer id) {
        TypeOfClass newO = typeOfClassRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        newO.setId(id);
        newO.setStudents(o.getStudents());
        newO.setSubject(o.getSubject());
        newO.setTeacher(o.getTeacher());
        newO.setYearTaught(o.getYearTaught());
        return typeOfClassRepository.saveAndFlush(newO);
    }

    @Override
    public void delete(TypeOfClass o) {
        typeOfClassRepository.delete(o);
    }

    @Override
    public TypeOfClass findOneById(Integer id) {
        return typeOfClassRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}