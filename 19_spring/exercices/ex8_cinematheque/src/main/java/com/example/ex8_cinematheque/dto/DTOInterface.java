package com.example.ex8_cinematheque.dto;

import java.io.Serializable;

public interface DTOInterface<T extends Serializable> {
    T toDTO();
    T toEntity();
}
