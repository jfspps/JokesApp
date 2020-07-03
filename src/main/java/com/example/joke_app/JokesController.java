package com.example.joke_app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {

    private JokeService jokeService;

    //@AutoWired not required for Spring 5
    public JokesController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""})
    public String getJoke(Model model){
        //append model with a joke
        model.addAttribute("joke", jokeService.getQuote());
        //"joke" is the ID used in the Thymeleaf HTML

        //chucknorris is the thymeleaf view name
        return "chucknorris";
    }
}
