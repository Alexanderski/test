package com.example.demo.dao;

import com.example.demo.dto.MarkDto;
import com.example.demo.dto.StoreDto;
import com.example.demo.rowMapper.MarkStoresRowMapper;
import com.example.demo.rowMapper.StoreRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StoreDaoImpl implements StoreDao {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private String GET_ALL_STORES = "SELECT * FROM store";
    private String Get_Mark_With_Store_By_MarkId = "select mark.id as mark_id , mark.name as mark_name, store.id as" +
            " store_id, store.name as store_name from mark join store on mark.id=store.mark_id where mark.id = :id";
    private String GET_STORE_BY_ID = "SELECT * FROM store WHERE id = :id";
    private String SAVE_STORE = "insert into store(name, mark_id) values (:name, :mark_id)";
    private String UPDATE_STORE = "UPDATE store set name = :name where id = :id ";
    private String DELETE_STORE = "DELETE FROM store WHERE id = :id ";

    @Autowired
    public StoreDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<StoreDto> getAllStores() {
        return namedParameterJdbcTemplate.query(GET_ALL_STORES, new StoreRowMapper());
    }

    /*@Override
    public MarkDto getMarkWithStoresByMarkId(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return namedParameterJdbcTemplate.query(Get_Mark_With_Store_By_MarkId, params, new MarkStoresRowMapper());
    }*/

    @Override
    public StoreDto getStoreById(int id) {
        Map<String , Object> params = new HashMap<>();
        params.put("id", id);
        return namedParameterJdbcTemplate.queryForObject(GET_STORE_BY_ID, params, new StoreRowMapper());
    }

    @Override
    public void saveOrUpdate(StoreDto storeDto) {
        Map<String , Object> params = new HashMap<>();
        params.put("name",storeDto.getName());
        if (storeDto.getId() == 0){
            params.put("mark_id", storeDto.getMark_id());
            namedParameterJdbcTemplate.update(SAVE_STORE, params);
        } else {
            params.put("id", storeDto.getId());
            namedParameterJdbcTemplate.update(UPDATE_STORE,params);
        }

    }

    @Override
    public void deleteStore(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        namedParameterJdbcTemplate.update(DELETE_STORE,params);

    }
}
