package com.firstspringproject.songr.controller;


import com.firstspringproject.songr.model.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
public class routes {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", "Welcome To Songer app");
        return "Splash";
    }

    @GetMapping("/hello")
    public String helloworld (@RequestParam(name = "Hello", required = false, defaultValue = "Hello World") String name,
                            Model model) {
        model.addAttribute("Hello", name);
        return "helloworld";
    }

    @GetMapping("/capitalize/{text}")
    public String Capitalize(Model model, @PathVariable String text) {
        model.addAttribute("Text" , text.toUpperCase());
        return "capitalize.html";
    }


    @GetMapping("/albums")
    public String Album(Model model) {
        Album album1 = new Album("Night Life", "Sara Lovell", 4, 180, "https://redtri.com/wp-content/uploads/2020/05/night-life.jpg?w=605");
        Album album2 = new Album("Dinosaurs and Metaphors", "Danny Weinkauf", 8, 240, "https://redtri.com/wp-content/uploads/2020/05/dinosaurs-and-metaphors.png?w=605");
        Album album3 = new Album("Unhurried Journey", "Elena Moon Park", 6, 300, "https://redtri.com/wp-content/uploads/2020/05/unhurried-journey.jpg?w=605");
        ArrayList<Album> albums = new ArrayList<>();
        albums.add(album1);
        albums.add(album2);
        albums.add(album3);

        model.addAttribute("Albums", albums);
        return "albums.html";
    }


}