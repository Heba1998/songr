package com.firstspringproject.songr.controller;


import com.firstspringproject.songr.model.Album;
import com.firstspringproject.songr.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


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

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String getalbum(Model model) {
        model.addAttribute("Album", albumRepository.findAll());
        return "albums";
    }



    @PostMapping("/albums")
    public RedirectView createNewAlbum(@ModelAttribute Album album , Model model) {
       model.addAttribute("album" , album);
        albumRepository.save(album);
        return new RedirectView("albums");
    }



}