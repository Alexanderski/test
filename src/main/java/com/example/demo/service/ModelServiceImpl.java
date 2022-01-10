package com.example.demo.service;

import com.example.demo.dao.ModelDao;
import com.example.demo.dto.MarkDto;
import com.example.demo.dto.ModelDto;
import com.example.demo.dto.StoreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService{
    private ModelDao modelDao;
    @Autowired
    public ModelServiceImpl(ModelDao modelDao) {
        this.modelDao = modelDao;
    }

    @Override
    public List<StoreDto> getAllMarks() {
        return null;
    }

    @Override
    public MarkDto getMarkWithModelsByMarkId(int id) {
        return modelDao.getMarkWithModelsByMarkId(id);
    }

    @Override
    public ModelDto getModelById(int id) {
        return modelDao.getModelById(id);
    }

    @Override
    public void saveOrUpdate(ModelDto modelDto) {
        modelDao.saveOrUpdate(modelDto);
    }

    @Override
    public void deleteModel(int id) {
        modelDao.deleteModel(id);
    }
}
