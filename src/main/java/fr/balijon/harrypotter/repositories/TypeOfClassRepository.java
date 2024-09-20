package fr.balijon.harrypotter.repositories;

import fr.balijon.harrypotter.entity.TypeOfClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfClassRepository extends JpaRepository<TypeOfClass, Integer> {
}
