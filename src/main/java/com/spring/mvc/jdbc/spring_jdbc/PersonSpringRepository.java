package com.spring.mvc.jdbc.spring_jdbc;

import com.spring.mvc.jdbc.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonSpringRepository {

    //스프링 JDBC 활용 - 데이터베이스 접속 설정 정보를
    //설정파일을 통해 불러와서 사용합니다.
    private final JdbcTemplate jdbcTemplate;

    public void savePerson(Person p) {
        String sql = "INSERT INTO person" +
                "(person_name,person_age)" +
                "VALUES(?,?)";

        //내부에 jdbc의 구조들이 전부 캡슐화 되어 있다.
        jdbcTemplate.update(sql, p.getPersonName(), p.getPersonAge());
    }

    public void removePerson(long id) {
        String sql = "DELETE FROM person" +
                " WHERE id = ?";

        //내부에 jdbc의 구조들이 전부 캡슐화 되어 있다.
        jdbcTemplate.update(sql, id);
    }

    public boolean modifyPerson(Person p) {
        String sql = "UPDATE person SET person_name=?,person_age=? WHERE id = ?";
        int result = jdbcTemplate.update(sql, p.getPersonName(), p.getPersonAge(), p.getId());
        return result == 1;
    }

    //전체 조회 기능
    public List<Person> findAll() {
        String sql = "SELECT * FROM person";
        //query에 맵핑
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Person(rs));
    }

    public Person findOne(long id){
        String sql = "SELECT * FROM person WHERE id=?";
        return jdbcTemplate.queryForObject(sql,(rs, rowNum) -> new Person(rs),id);


    }

}
