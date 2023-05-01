package com.spring.mvc.mybatis;

import com.spring.mvc.jdbc.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonMapperTest {

    @Autowired
    PersonMapper mapper;

    @Test
    @DisplayName("Mabits Mapper로 사람정보 저장에 성공해야 한다.")
    void saveTest(){
        //given
        Person p = Person.builder()
                .personAge(23)
                .personName("영수")
                .build();
        //when
        boolean flag = mapper.save(p);

        //then
        assertTrue(flag);
    }

    @Test
    @DisplayName("Mabits Mapper로 사람정보 수정에 성공해야 한다.")
    void changeTest(){
        Person p = Person.builder()
                .personName("수정합니다")
                .personAge(50)
                .id(1L)
                .build();

        //when
        boolean flag = mapper.change(p);

        //then
        assertTrue(flag);
    }

    @Test
    @DisplayName("Mabits Mapper로 사람정보 삭제에 성공해야 한다.")
    void removeTest(){
        long id = 6L;

        //when
        boolean flag = mapper.remove(id);

        //then
        assertTrue(flag);
    }

    @Test
    @DisplayName("Mabits Mapper로 사람정보 출력에 성공해야 한다.")
    void findAllTest(){
        //when
        List<Person> all = mapper.findAll();
        //then
        all.forEach(System.out::println);
        assertEquals(7,all.size());
    }

    @Test
    @DisplayName("Mabits Mapper로 사람정보 출력에 성공해야 한다.")
    void findOneTest(){
        //when
        long id = 1L;
        //then
        Person one = mapper.findOne(id);
        System.out.println("one = " + one);
        assertEquals("수정합니다", one.getPersonName());
        assertNotNull(one);
    }
}