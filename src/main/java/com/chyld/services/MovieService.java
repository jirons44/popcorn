package com.chyld.services;

import com.chyld.entities.Movie;
import com.chyld.entities.Studio;
import com.chyld.repositories.IMovieRepository;
import com.chyld.repositories.IStudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private IMovieRepository repository;

    @Autowired
    public void setRepository(IMovieRepository repository) {
        this.repository = repository;
    }

    public Page<Movie> findAll(int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.findAll(pr);
    }

    public Movie findOne(int id) {
        return this.repository.findOne(id);
    }

    public Movie create(Movie m) {
        return this.repository.save(m);
    }

    public void destroy(int id) {
        this.repository.delete(id);
    }
}