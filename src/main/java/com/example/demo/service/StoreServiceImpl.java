package com.example.demo.service;

import com.example.demo.dao.StoreDao;
import com.example.demo.dto.MarkDto;
import com.example.demo.dto.StoreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService{
    private StoreDao storeDao;
    @Autowired
    public StoreServiceImpl(StoreDao storeDao) {
        this.storeDao = storeDao;
    }

    @Override
    public List<StoreDto> getAllStores() {
        return storeDao.getAllStores();
    }

   /* @Override
    public MarkDto getMarkWithStoresByMarkId(int id) {
        return storeDao.getMarkWithStoresByMarkId(id);
    }*/

    @Override
    public StoreDto getStoreById(int id) {
        return storeDao.getStoreById(id);
    }

    @Override
    public void saveOrUpdate(StoreDto storeDto) {
        storeDao.saveOrUpdate(storeDto);

    }

    @Override
    public void deleteStore(int id) {
        storeDao.deleteStore(id);
    }
}
