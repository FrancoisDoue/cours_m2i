package com.example.ex8_cinematheque.service;

import com.example.ex8_cinematheque.dto.DirectorDTOPost;
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

    public List<Director> getAllDirectors() {
        return (List<Director>) directorRepository.findAll();
    }

    public Director createDirector(DirectorDTOPost director) {
        return directorRepository.save(director.toEntity());
    }

    public Director updateDirector(int id, DirectorDTOPost director) {
        if (!directorRepository.existsById(id)) throw new NotFoundException("Director not found");
        Director directorToUpdate = director.toEntity();
        directorToUpdate.setId(id);
        return directorRepository.save(directorToUpdate);
    }

    public void deleteDirector(int id) {
        Director director = this.getDirectorById(id);
        directorRepository.delete(director);
    }
}
