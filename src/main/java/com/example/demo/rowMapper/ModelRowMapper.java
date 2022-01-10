package com.example.demo.rowMapper;

import com.example.demo.dto.MarkDto;
import com.example.demo.dto.ModelDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelRowMapper implements RowMapper<ModelDto> {
    @Override
    public ModelDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        ModelDto modelDto = new ModelDto();
        modelDto.setId(rs.getInt("id"));
        modelDto.setName(rs.getString("name"));
        modelDto.setMark_id(rs.getInt("mark_id"));
        return modelDto;
    }
}
