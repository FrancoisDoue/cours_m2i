package com.example.ex8_cinematheque.dto;

import java.io.Serializable;

public interface IDTO<T extends Serializable> {
    T toEntity();

    IDTO<T> fromEntity(T entity);
}
