package com.noroff.Ass2DataAccess.view;

import com.noroff.Ass2DataAccess.controllers.ArtistController;
import com.noroff.Ass2DataAccess.controllers.GenreController;
import com.noroff.Ass2DataAccess.controllers.TrackController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
    private final ArtistController artistController;
    private final TrackController trackController;
    private final GenreController genreController;

    public HomeController (
            ArtistController artistController,
            TrackController trackController,
            GenreController genreController
    ) {
        this.artistController = artistController;
        this.trackController = trackController;
        this.genreController = genreController;
    }


    @GetMapping("/")
    public String view(
            Model model
    ) {
        model.addAttribute("artists", artistController.getRandom(5));
        model.addAttribute("tracks", trackController.getRandom(5));
        model.addAttribute("genres", genreController.getRandom(5));
        return "home";
    }

    @GetMapping("/search")
    public String search (
            @RequestParam( name = "query", required = true) String query,
            Model model
    ) {
        if(query != null && !query.equals("")) {
            model.addAttribute("searchResults", trackController.search(query.toLowerCase()));
            model.addAttribute("query", query);
            return "results";
        } else {
            model.addAttribute("artists", artistController.getRandom(5));
            model.addAttribute("tracks", trackController.getRandom(5));
            model.addAttribute("genres", genreController.getRandom(5));
            return "home";
        }
    }
}
