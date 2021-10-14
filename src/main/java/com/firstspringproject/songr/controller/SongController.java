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
public class SongController {

    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/songs")
    public String getsong(Model model){
        List<Song> songs=songRepository.findAll();
        model.addAttribute("songs", songs);
        return "AllSong";
    }


    @PostMapping("/album/{id}/songs")
    public RedirectView addSong(String title, int length, int trackNumber, @PathVariable long id) {
        Album album = albumRepository.findById(id).get();
        Song song = new Song(title, length, trackNumber, album);
        songRepository.save(song);
        return new RedirectView("/album/" + id);
    }

}
