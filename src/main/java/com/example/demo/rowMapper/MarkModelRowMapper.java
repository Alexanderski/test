package com.example.demo.rowMapper;

import com.example.demo.dto.MarkDto;
import com.example.demo.dto.ModelDto;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MarkModelRowMapper implements ResultSetExtractor<MarkDto> {
    @Override
    public MarkDto extractData(ResultSet rs) throws SQLException, DataAccessException {
        MarkDto markDto = new MarkDto();
        while (rs.next()) {
            if (markDto.getId() == 0) {
                markDto.setId(rs.getInt("mark_id"));
                markDto.setName(rs.getString("mark_name"));
            }
            ModelDto modelDto = new ModelDto();
            modelDto.setId(rs.getInt("model_id"));
            modelDto.setName(rs.getString("model_name"));

            List<ModelDto> models = markDto.getModels();
            models.add(modelDto);
            markDto.setModels(models);
        }
        return markDto;
    }

}
