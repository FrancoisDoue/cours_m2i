package com.example.ex8_cinematheque.service;

import com.example.ex8_cinematheque.dto.DirectorDTO;
import com.example.ex8_cinematheque.entity.Director;
import com.example.ex8_cinematheque.exception.NotFoundException;
import com.example.ex8_cinematheque.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {

    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public Director getDirectorById(int id) {
        return directorRepository.findById(id).orElseThrow(() -> new NotFoundException("Director not found"));
    }

    public List<DirectorDTO> getAllDirectors() {
        List<Director> directors = (List<Director>) directorRepository.findAll();
        return directors.stream().map(DirectorDTO::new).toList();
    }

    public Director createDirector(Director director) {
        return directorRepository.save(director);
    }

    public DirectorDTO updateDirector(int id, Director director) {
        if (!directorRepository.existsById(id)) throw new NotFoundException("Director not found");
        director.setId(id);
        return new DirectorDTO(directorRepository.save(director));
    }

    public void deleteDirector(int id) {
        Director director = this.getDirectorById(id);
        directorRepository.delete(director);
    }
}
