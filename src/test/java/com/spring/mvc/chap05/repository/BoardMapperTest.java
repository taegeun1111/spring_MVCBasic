package com.spring.mvc.chap05.repository;

import com.spring.mvc.chap05.dto.BoardSaveRequestDTO;
import com.spring.mvc.chap05.entity.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    BoardMapper boardMapper;

    @Test
    @DisplayName("게시물 300개를 작성해야 한다.")
    void bulkInsertTest(){
        //Given
        for (int i = 1; i <=300; i++) {
            Board b = Board.builder()
                    .title("테스트 제목 "+ i)
                    .content("테스트 내용 "+i)
                    .build();
            boardMapper.save(b);
        }


    }
}