package com.firstspringproject.songr.controller;

import com.firstspringproject.songr.model.Album;
import com.firstspringproject.songr.model.Song;
import com.firstspringproject.songr.repository.AlbumRepository;
import com.firstspringproject.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {
    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;


    @GetMapping("/albums")
    public String getAllAlbums(Model model) {
        List<Album> albums = albumRepository.findAll();
        model.addAttribute("albums", albums);
        return "albums";
    }




    @PostMapping("/albums")
    public RedirectView createNewAlbum(String title, String artist, int songCount, int length, String imageUrl) {
        Album a = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(a);
        return new RedirectView("/albums");
    }


    @GetMapping("/album/{id}")
    public String AlbumById(@PathVariable long id, Model model){
        Album albums = albumRepository.findById(id).get();
        model.addAttribute("album", albums);
        List<Song> songs= songRepository.findByAlbum(albums);
        model.addAttribute("songs", songs);
        return "IdAlbum";
    }
}
