package repository;

import model.Boutique;
import model.Ccategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CategoryRepository extends JpaRepository<Ccategory,Integer>, CrudRepository<Ccategory, Integer> {
    Ccategory findByLibelle(String name);

    Ccategory findById(UUID id);
    public UUID getId();
    public String getLibelle();
    }
