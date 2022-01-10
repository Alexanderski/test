package com.example.demo.dao;

import com.example.demo.dto.MarkDto;
import com.example.demo.dto.ModelDto;

public interface ModelDao {
    MarkDto getMarkWithModelsByMarkId (int id);
    ModelDto getModelById(int id);
    void saveOrUpdate (ModelDto modelDto);
    void deleteModel (int id);
}
