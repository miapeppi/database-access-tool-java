package com.noroff.Ass2DataAccess.view;

import com.noroff.Ass2DataAccess.controllers.ArtistController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final ArtistController artistController;

    public HomeController (
            ArtistController artistController
    ) {this.artistController = artistController; }


    @GetMapping("/")
    public String view(
            Model model
    ) {
        model.addAttribute("artists", artistController.getRandom());
        return "home";
    }
}
