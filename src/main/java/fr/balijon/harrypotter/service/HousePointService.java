package fr.balijon.harrypotter.service;

import fr.balijon.harrypotter.entity.HousePoint;
import fr.balijon.harrypotter.repositories.HousePointRepository;
import fr.balijon.harrypotter.service.interfaces.ServiceListInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HousePointService implements ServiceListInterface<HousePoint, Integer, HousePoint, HousePoint> {

    HousePointRepository housePointRepository;

    @Override
    public List<HousePoint> list() {
        return housePointRepository.findAll();
    }

    @Override
    public HousePoint create(HousePoint o) {
        return housePointRepository.saveAndFlush(o);
    }

    @Override
    public HousePoint update(HousePoint o, Integer id) {
        HousePoint newO = housePointRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        newO.setId(id);
        newO.setHouse(o.getHouse());
        newO.setTotalPoint(o.getTotalPoint());
        newO.setYear(o.getYear());
        return housePointRepository.saveAndFlush(newO);
    }

    @Override
    public void delete(HousePoint o) {
    housePointRepository.delete(o);
    }

    @Override
    public HousePoint findOneById(Integer id) {
        return housePointRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
