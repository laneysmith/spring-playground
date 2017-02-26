package com.example;

import com.example.models.Album;
import com.example.repositories.AlbumRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
public class RecordStoreController {
    private final AlbumRepository albumRepository;

    public RecordStoreController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @GetMapping("")
    public Iterable<Album> listAlbums() {
        return this.albumRepository.findAll();
    }

    @PostMapping("")
    public Album create(@RequestBody Album album) {
        this.albumRepository.save(album);
        return album;
    }

}
