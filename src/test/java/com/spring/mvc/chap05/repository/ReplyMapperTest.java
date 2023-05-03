package com.spring.mvc.chap05.repository;

import com.spring.mvc.chap05.dto.Page.Page;
import com.spring.mvc.chap05.dto.Page.Search;
import com.spring.mvc.chap05.entity.Board;
import com.spring.mvc.chap05.entity.Reply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional
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

    @Test
    @DisplayName("댓글을 3번 게시물에 등록하면 3번 게시물의 총 댓글 수는 4개여야 한다.")
    @Transactional //테스트 끝난 이후 롤백해라
    void saveTest() {
        //given
        long boardNo =3;
        Reply newReply = Reply.builder()
                .replyText("세이브2")
                .replyWriter("홍길동")
                .boardNo(boardNo)
                .build();
        //when
        boolean flag = replyMapper.save(newReply);

        //then
        assertTrue(flag);
        assertEquals(5, replyMapper.count(boardNo));
    }

    @Test
    @DisplayName("댓글번호가 1001번인 댓글을 삭제하면" +
            "3번 게시물의 총 댓글 수가 3이어야 한다.")
    @Transactional
    void deleteTest(){
        //given
        long replyNo =1001L;
        long boardNo = 3L;
        //when
        boolean flag = replyMapper.deleteOne(replyNo);

        //then
        assertTrue(flag);
        assertEquals(3,replyMapper.count(boardNo));
    }

    @Test
    @DisplayName("댓글번호가 1001번인 댓글을 수정하면" +
            "해당 replyNo의 reply_text와 같아야 한다.")
    @Transactional
    void modifyTest(){
        //given
        String newText = "대한민국 만세";
        Reply build = Reply.builder()
                .replyNo(1000L)
                .replyText(newText)
                .boardNo(3L)
                .build();
        //when
        boolean modify = replyMapper.modify(build);

        //then
        assertTrue(modify);
        assertEquals(newText,replyMapper.findOne(build.getReplyNo()).getReplyText());
//        assertEquals(4, replyMapper.count(build.getBoardNo()));

    }

    @Test
    @DisplayName("전체 조회 시 답글의 개수는 1002개가 나와야 한다.")
    void findAllTest(){
        //given
        Page page = new Page();
        long boardNo = 1L;

        //when


    }


}