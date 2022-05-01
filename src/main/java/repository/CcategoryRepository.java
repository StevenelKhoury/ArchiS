package repository;

import model.Ccategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CcategoryRepository extends JpaRepository<Ccategory,Integer>, CrudRepository<Ccategory, Integer> {
    Ccategory findByLibelle(String name);

    Ccategory findById(UUID id);
    public UUID getId();
}
