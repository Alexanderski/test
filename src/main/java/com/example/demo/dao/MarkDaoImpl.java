package com.example.demo.dao;

import com.example.demo.dto.MarkDto;
import com.example.demo.rowMapper.MarkRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MarkDaoImpl implements MarkDao{

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private String GET_ALL_MARKS = "SELECT * FROM mark";
    private String GET_MARK_BY_ID = "SELECT * FROM mark WHERE id = :id";
    private String SAVE_MARK = "INSERT INTO mark(name) values (:name)";
    private String UPDATE_MARK = "UPDATE mark set name = :name where id = :id ";
    private String DELETE_MARK = "DELETE FROM mark WHERE id = :id ";

    @Autowired
    public MarkDaoImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<MarkDto> getAllMarks() {
        return namedParameterJdbcTemplate.query(GET_ALL_MARKS, new MarkRowMapper ());
    }

    @Override
    public MarkDto getMarkById(int id) {
        Map<String , Object> params = new HashMap<>();
        params.put("id", id);
        return namedParameterJdbcTemplate.queryForObject(GET_MARK_BY_ID, params, new MarkRowMapper());
    }

    @Override
    public void saveOrUpdate(MarkDto markDto) {
        Map<String , Object> params = new HashMap<>();
        params.put("name",markDto.getName());
        if (markDto.getId() == 0){
            namedParameterJdbcTemplate.update(SAVE_MARK,params);
        } else {
            params.put("id", markDto.getId());
            namedParameterJdbcTemplate.update(UPDATE_MARK,params);
        }

    }

    @Override
    public void deleteMark(int id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        namedParameterJdbcTemplate.update(DELETE_MARK,params);
    }
}
