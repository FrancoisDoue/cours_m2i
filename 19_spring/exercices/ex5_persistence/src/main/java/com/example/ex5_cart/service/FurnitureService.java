package com.example.ex5_cart.service;

import com.example.ex5_cart.model.Furniture;
import com.example.ex5_cart.repository.CartItemRepository;
import com.example.ex5_cart.repository.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FurnitureService {

    private final FurnitureRepository furnitureRepository;

    @Autowired
    public FurnitureService(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }

    public List<Furniture> getAllFurniture() {
        return furnitureRepository.findAll();
    }

    public void saveFurniture(Furniture furniture) {
        furnitureRepository.save(furniture);
    }

    public Furniture getFurnitureById(long id) {
        return furnitureRepository.getReferenceById(id);
    }

    public void deleteFurniture(long id) {
        furnitureRepository.deleteById(id);
    }

}
