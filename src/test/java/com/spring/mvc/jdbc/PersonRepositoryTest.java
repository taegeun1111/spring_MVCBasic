package com.spring.mvc.jdbc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    PersonRepository repository;

    @Test
    @DisplayName("사람의 이름과 나이 정보를 DB person table에 잘 삽입해야 한다.")
    void saveTest(){
        //given
        Person p = new Person();
        p.setPersonName("뽀리리");
        p.setPersonAge(60);

        //when
        repository.save(p);
        //then
    }
    @Test
    @DisplayName("사람의 이름과 나이 정보를 DB person table에 잘 tnwjd해야 한다.")
    void insertTest(){
        //given
        Person p = new Person();
        p.setPersonName("수정");
        p.setPersonAge(99);
        p.setId(1L);
        //when
        repository.insert(p);
        //then
    }


    @Test
    @DisplayName("사람의 이름과 나이 정보를 DB person table에 잘 tnwjd해야 한다.")
    void removeTest(){
        //given
        long id = 3L;
        //when
        repository.remove(id);
        //then
    }

}