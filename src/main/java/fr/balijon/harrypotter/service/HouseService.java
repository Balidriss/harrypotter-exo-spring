package fr.balijon.harrypotter.service;

import fr.balijon.harrypotter.entity.House;
import fr.balijon.harrypotter.repositories.HouseRepository;
import fr.balijon.harrypotter.service.interfaces.ServiceListInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HouseService implements ServiceListInterface<House, Integer, House, House> {

    HouseRepository houseRepository;

    @Override
    public List<House> list() {
        return houseRepository.findAll();
    }

    @Override
    public House create(House o) {
        return houseRepository.saveAndFlush(o);
    }

    @Override
    public House update(House o, Integer id) {
        House newO = houseRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        newO.setId(id);
        newO.setHouseName(o.getHouseName());
        newO.setFounderFirstName(o.getFounderFirstName());
        newO.setFounderLastName(o.getFounderLastName());
        return houseRepository.saveAndFlush(newO);
    }

    @Override
    public void delete(House o) {
    houseRepository.delete(o);
    }

    @Override
    public House findOneById(Integer id) {
        return houseRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
