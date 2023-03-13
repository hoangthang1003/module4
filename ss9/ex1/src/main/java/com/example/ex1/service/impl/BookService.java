package com.example.ex1.service.impl;

import com.example.ex1.model.Book;
import com.example.ex1.repository.IBookRepository;
import com.example.ex1.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    @Autowired
    IBookRepository iBookRepository;


    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public void create(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id).get();
    }
}
