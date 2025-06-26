package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Album;
import com.example.springBoot2.repositories.AlbumRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }
    //Implement the getAllItems method in each of the controllers. This method should call the findAll method on the JPA repository and return the result, and should be annotated with @GetMapping//
    @GetMapping("")
    public List<Album> getAllItems (){
        return albumRepository.findAll();
    }

    //Implement the getItem method in each of the controllers. This method should call the findById method on the JPA repository and return the result, and should be annotated with @GetMapping('/{id}') and have a mapped @PathVariable parameter for the id of type int.//
    @GetMapping("/albums/{id}")
    public Optional<Album> getItem(@PathVariable int id){
        return albumRepository.findById(id);
    }
    //Implement the addItem method in each of the controllers. This method should call the save method on the JPA repository and return the result, and should be annotated with @PostMapping with a @RequestBody parameter//
    @PostMapping("/albums")
    public Album addItem (@RequestBody Album album){
        return albumRepository.save(album);
    }
    //Implement the updateItem method in each of the controllers. This method should call the save method on the JPA repository and return the result, and should be annotated with @PutMapping('/{id}') with a @PathVariable parameter for the id of type int and a @RequestBody parameter.//
    @PutMapping ("/albums/{id}")
    public Album updateItem (@PathVariable int id, @RequestBody Album album){
        album.setId(id);
        return albumRepository.save(album);
    }
    //Implement the deleteItem method in each of the controllers. This method should call the deleteById method on the JPA repository and should be annotated with @DeleteMapping('/{id}') with a @PathVariable parameter for the id of type int.
    @DeleteMapping("/albums/{id}")
    public void deleteItem(@PathVariable int id){
        albumRepository.deleteById(id);
    }


}
