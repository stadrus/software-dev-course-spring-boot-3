package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Album;
import com.example.springBoot2.repositories.AlbumRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @GetMapping
    public List<Album> getAlbums() {
        return albumRepository.findAll();
    }

    @GetMapping("/{id}")
    public Album getAlbumById(@PathVariable Integer id) {
        return albumRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Album createAlbum(@RequestBody Album album) {
        albumRepository.save(album);
        return album;
    }

    @PutMapping("/{id}")
    public Album updateAlbum(@PathVariable Integer id, @RequestBody Album album) {
        album.setId(id);
        albumRepository.save(album);
        return album;
    }

    @DeleteMapping("/{id}")
    public void deleteAlbum(@PathVariable Integer id) {
        albumRepository.deleteById(id);
    }
}
