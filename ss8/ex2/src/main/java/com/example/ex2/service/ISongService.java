package com.example.ex2.service;

import com.example.ex2.model.Song;

import java.util.Optional;

public interface ISongService {
    Iterable<Song> findAll();

    Optional<Song> findById(Integer id);

    void save(Song song);

    void deleteBlog(Integer id);
}
