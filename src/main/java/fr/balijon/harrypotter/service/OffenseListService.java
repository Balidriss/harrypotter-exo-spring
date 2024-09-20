package fr.balijon.harrypotter.service;

import fr.balijon.harrypotter.entity.OffenseList;
import fr.balijon.harrypotter.repositories.OffenseListRepository;
import fr.balijon.harrypotter.service.interfaces.ServiceListInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OffenseListService implements ServiceListInterface<OffenseList, Integer, OffenseList, OffenseList> {

    OffenseListRepository offenseListRepository;

    @Override
    public List<OffenseList> list() {
        return offenseListRepository.findAll();
    }

    @Override
    public OffenseList create(OffenseList o) {
        return offenseListRepository.saveAndFlush(o);
    }

    @Override
    public OffenseList update(OffenseList o, Integer id) {
        OffenseList newO = offenseListRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        newO.setOffense(o.getOffense());
        newO.setStudent(o.getStudent());
        newO.setOffenseSeriousness(o.getOffenseSeriousness());
        newO.setCreatedAt(o.getCreatedAt());
        newO.setId(id);
        return offenseListRepository.saveAndFlush(newO);
    }

    @Override
    public void delete(OffenseList o) {
        offenseListRepository.delete(o);
    }

    @Override
    public OffenseList findOneById(Integer id) {
        return offenseListRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
