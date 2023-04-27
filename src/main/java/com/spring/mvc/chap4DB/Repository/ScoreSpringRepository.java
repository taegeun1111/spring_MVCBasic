package com.spring.mvc.chap4DB.Repository;

import com.spring.mvc.chap4DB.entity.Score;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("spring")
@RequiredArgsConstructor
public class ScoreSpringRepository implements ScoreRepository{
    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<Score> findAll() {
        return null;
    }

    @Override
    public List<Score> findAll(String sort) {
        String sql = "SELECT * FROM tbl_score";
        switch (sort){
            case "num" :
                sql += " ORDER BY stu_num";
                break;
            case "name" :
                sql += " ORDER BY stu_name";
                break;
            case "avg" :
                sql += " ORDER BY average DESC";
                break;
        }
        return jdbcTemplate.query(sql,(rs, rowNum) ->new Score(rs));
    }

    @Override
    public boolean save(Score score) {
        return false;
    }

    @Override
    public boolean deleteByStuNum(int stuNum) {
        return false;
    }

    @Override
    public Score findByStuNum(int stuNum) {
        return null;
    }
}
