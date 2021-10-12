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

    @GetMapping("/song")
    public String getsong(Model model){
        List<Song> song=songRepository.findAll();
        model.addAttribute("song", song);
        return "AllSong";
    }


    @PostMapping("/album/{id}/song")
    public RedirectView AddSong (String title, int length, int trackNumber, @PathVariable long id){
        Album albums = albumRepository.findById(id).get();
        Song songs = new Song(title, length, trackNumber, albums);
        songRepository.save(songs);
        return new RedirectView("/album/{id}");
    }

}
