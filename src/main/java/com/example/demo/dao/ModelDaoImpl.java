package com.example.demo.dao;

import com.example.demo.dto.MarkDto;
import com.example.demo.dto.ModelDto;
import com.example.demo.rowMapper.MarkModelRowMapper;
import com.example.demo.rowMapper.ModelRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class ModelDaoImpl implements ModelDao{

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private String Get_Mark_With_Model_By_MarkId = "select mark.id as mark_id , mark.name as mark_name, model.id as" +
            " model_id, model.name as model_name from mark join model on mark.id=model.mark_id where mark.id = :id";
    private String GET_MODEL_BY_ID = "SELECT * FROM model WHERE id = :id";
    private String SAVE_MODEL = "insert into model(name, mark_id) values (:name, :mark_id)";
    private String UPDATE_MODEL = "UPDATE model set name = :name where id = :id ";
    private String DELETE_MODEL = "DELETE FROM model WHERE id = :id ";
    @Autowired
    public ModelDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public MarkDto getMarkWithModelsByMarkId(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return namedParameterJdbcTemplate.query(Get_Mark_With_Model_By_MarkId, params, new MarkModelRowMapper());
    }

    @Override
    public ModelDto getModelById(int id) {
        Map<String , Object> params = new HashMap<>();
        params.put("id", id);
        return namedParameterJdbcTemplate.queryForObject(GET_MODEL_BY_ID, params, new ModelRowMapper());
    }

    @Override
    public void saveOrUpdate(ModelDto modelDto) {
        Map<String , Object> params = new HashMap<>();
        params.put("name",modelDto.getName());
        if (modelDto.getId() == 0){
            params.put("mark_id", modelDto.getMark_id());
            namedParameterJdbcTemplate.update(SAVE_MODEL, params);
        } else {
            params.put("id", modelDto.getId());
            namedParameterJdbcTemplate.update(UPDATE_MODEL,params);
        }
    }
    @Override
    public void deleteModel(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        namedParameterJdbcTemplate.update(DELETE_MODEL,params);

    }
}
