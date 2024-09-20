package fr.balijon.harrypotter.service;

import fr.balijon.harrypotter.entity.HousePoint;
import fr.balijon.harrypotter.entity.Offense;
import fr.balijon.harrypotter.repositories.OffenseRepository;
import fr.balijon.harrypotter.service.interfaces.ServiceListInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OffenseService implements ServiceListInterface<Offense, Integer, Offense, Offense> {

    OffenseRepository offenseRepository;

    @Override
    public List<Offense> list() {
        return offenseRepository.findAll();
    }

    @Override
    public Offense create(Offense o) {
        return offenseRepository.saveAndFlush(o);
    }

    @Override
    public Offense update(Offense o, Integer id) {
        Offense newO = offenseRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        newO.setId(id);
        newO.setLabel(o.getLabel());
        return offenseRepository.saveAndFlush(newO);
    }

    @Override
    public void delete(Offense o) {
       offenseRepository.delete(o);
    }

    @Override
    public Offense findOneById(Integer id) {
        return offenseRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
