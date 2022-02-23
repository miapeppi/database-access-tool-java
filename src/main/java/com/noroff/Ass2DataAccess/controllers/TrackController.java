package com.noroff.Ass2DataAccess.controllers;

import com.noroff.Ass2DataAccess.data.TrackRepository;
import com.noroff.Ass2DataAccess.models.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/track")
public class TrackController {
    private final TrackRepository repo;

    public TrackController(@Autowired TrackRepository trackRepository) { this.repo = trackRepository; }

    @GetMapping("/random")
    public List<Track> getRandom(int amount) {
        List<Track> resultList = repo.getRandom(amount);
        return resultList;
    }

    public List<Track> search(String term) {
        List<Track> resultList = repo.search(term);
        return resultList;
    }
}
