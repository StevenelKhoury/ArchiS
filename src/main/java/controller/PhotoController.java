package controller;

import model.Boutique;
import model.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PhotoService;

import java.util.UUID;

@CrossOrigin(origins="http://localhost:5050")
@RestController
public class PhotoController {

    @Autowired
    private PhotoService service;

    public PhotoController(PhotoService service) {
        this.service = service;
    }

    @PostMapping("/photo")
    public Photo addPhoto(@RequestBody Photo a){
        return service.savePhoto(a);
    }

    @GetMapping("/photo/{id}")
    public Photo getPhoto(@RequestAttribute UUID id ){ return service.getPhoto(id);}



}
