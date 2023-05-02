package com.spring.mvc.chap05.repository;

import com.spring.mvc.chap05.dto.Page.Page;
import com.spring.mvc.chap05.entity.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ReplyMapper {

    //댓글 등록
    boolean save(Reply reply);

    //댓글 수정
    boolean modify(Reply reply);

    //댓글 삭제
    boolean deleteOne(long replyNo);

    //댓글 개별 조회
    Reply findOne(long replyNo);

    //댓글 목록 조회
    //2개 이상의 객체가 파라미터로 들어올 때는 별칭을 지정해줘야
    //같은 필드가 있어도 오류가 발생하지 않는다. ex)p.boarNo
    List<Reply> findAll(@Param("bn") long boardNo, @Param("p") Page page);

    //댓글 수 조회
    int count(long boardNo);
}
