package com.spring.mvc.chap05.repository;

import com.spring.mvc.chap05.dto.Page.Search;
import com.spring.mvc.chap05.entity.Board;
import com.spring.mvc.chap05.entity.Reply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyMapperTest {

    @Autowired
    ReplyMapper replyMapper;
    @Autowired
    BoardMapper boardMapper;

    @Test
    @DisplayName("게시물 300개를 등록하고 " +
            "각 게시물에 랜덤으로 1000개의 " +
            "댓글을 나눠서 등록해야 한다.")
    void bulkInsertTest() {

        for (int i = 1; i <= 300; i++) {
            Board b = Board.builder()
                    .title("재밌는 게시물 " + i)
                    .content("노잼 게시물 내용 " + i)
                    .build();
            boardMapper.save(b);
        }
        assertEquals(300, boardMapper.count(new Search()));

        for (int i = 1; i <= 1000; i++) {
            Reply r = Reply.builder()
                    .replyWriter("잼민이 " + i)
                    .replyText("말똥이~~~" + i)
                    .boardNo((long) (Math.random() * 300 + 1))
                    .build();
            replyMapper.save(r);
        }



    }

}