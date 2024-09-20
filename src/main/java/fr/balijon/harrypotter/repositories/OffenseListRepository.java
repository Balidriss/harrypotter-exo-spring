package fr.balijon.harrypotter.repositories;

import fr.balijon.harrypotter.entity.OffenseList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffenseListRepository extends JpaRepository<OffenseList, Integer> {
}
