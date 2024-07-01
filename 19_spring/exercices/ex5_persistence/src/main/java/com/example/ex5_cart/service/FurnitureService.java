package com.example.ex5_cart.service;

import com.example.ex5_cart.repository.FurnitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FurnitureService {

    private final FurnitureRepository furnitureRepository;

    @Autowired
    public FurnitureService(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }
}
