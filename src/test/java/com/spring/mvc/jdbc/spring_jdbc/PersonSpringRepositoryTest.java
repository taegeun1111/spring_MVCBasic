package com.spring.mvc.jdbc.spring_jdbc;

import com.spring.mvc.jdbc.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonSpringRepositoryTest {

    @Autowired
    PersonSpringRepository repository;

    @Test
    void savePersonTest(){
        //given
        Person p = new Person();
        p.setPersonName("김슾");
        p.setPersonAge(2);
        //when
        repository.savePerson(p);
        //then
    }

    @Test
    void removePersonTest(){
        //given
        long id = 2L;
        //when
        repository.removePerson(id);
    }

    @Test
    void updatePersonTest(){
        //given
        Person p = new Person();
        p.setPersonAge(30);
        p.setPersonName("이동우");
        p.setId(5L);
        //when
        repository.modifyPerson(p);
    }

    @Test
    void findAllTest(){
        List<Person> all = repository.findAll();
        for (Person person : all) {
            System.out.println("person = " + person);
        }
    }
    @Test
    void findOneTest(){
        long id = 1L;

        Person one = repository.findOne(id);
        System.out.println("one = " + one);
    }
}