package com.firstspringproject.songr.repository;


import com.firstspringproject.songr.model.Album;
import com.firstspringproject.songr.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    public List<Song> findByAlbum(Album album);
}


