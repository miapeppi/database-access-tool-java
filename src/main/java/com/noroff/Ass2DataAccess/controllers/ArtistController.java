package com.noroff.Ass2DataAccess.controllers;

import com.noroff.Ass2DataAccess.data.ArtistRepository;
import com.noroff.Ass2DataAccess.models.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/artist")
public class ArtistController {
    private final ArtistRepository repo;

    public ArtistController(@Autowired ArtistRepository artistRepository) {this.repo = artistRepository; }

    @GetMapping("/random")
    public List<Artist> getRandom() {
        List<Artist> resultList = repo.getRandom(5);
        return resultList;
    }
}
