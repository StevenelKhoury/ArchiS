package service;

import lombok.NoArgsConstructor;
import model.Article;
import model.Boutique;
import model.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PhotoRepository;

import java.util.List;
import java.util.UUID;

@Service
@NoArgsConstructor
public class PhotoService {

    private PhotoRepository repository;

    private List<Photo> photos;

    @Autowired
    public PhotoService(PhotoRepository repository) {
        this.repository = repository;
    }
    public Photo savePhoto(Photo photo){
        return repository.save(photo);
    }

    public Photo getId(UUID uuid){
        return repository.findById(uuid);
    }

    public Photo getPhoto(UUID id) { return photos.stream().filter(t -> t.getId().equals(id)).findFirst().get();}


}
