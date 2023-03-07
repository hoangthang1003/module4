package com.example.ex2.service.impl;

import com.example.ex2.model.Song;
import com.example.ex2.repository.ISongRepository;
import com.example.ex2.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongService implements ISongService {

    @Autowired
    ISongRepository songRepository;


    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Optional<Song> findById(Integer id) {
        return songRepository.findById(id);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void deleteBlog(Integer id) {

    }
}
