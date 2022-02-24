package com.noroff.Ass2DataAccess.controllers;

import com.noroff.Ass2DataAccess.data.GenreRepository;
import com.noroff.Ass2DataAccess.models.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
public class GenreController {
    private final GenreRepository repo;

    public GenreController(@Autowired GenreRepository genreRepository) { this.repo = genreRepository; }

    @GetMapping("/random")
    public List<Genre> getRandom() {
        List<Genre> resultList = repo.getRandom(5);
        return resultList;
    }
}
