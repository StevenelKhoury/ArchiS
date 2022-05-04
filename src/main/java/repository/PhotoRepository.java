package repository;

import model.Ccategory;
import model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhotoRepository extends JpaRepository<Photo,Integer>, CrudRepository<Photo, Integer> {
    Photo findById(UUID id);


}
