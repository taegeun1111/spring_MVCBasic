package com.spring.mvc.chap4DB.Repository;

import com.spring.mvc.chap4DB.entity.Score;

import java.util.List;

/**
 * 역할 명세(추상화) :
 * 성적 정보를 잘 저장하고 조회하고 삭제하고 수정해야 한다.
 * 저장 위치?, 조회 위치?, 삭제 위치?
 */
public interface ScoreRepository {


    //성적 정보 전체 목록 조회
    default List<Score> findAll(String sort){
        return null;
    };
    List<Score> findAll();

    //성적 정보 등록
    boolean save(Score score);

    //성적 정보 삭제
    //학번으로 삭제
    boolean deleteByStuNum(int stuNum);

    //성적 정보 개별 조회
    Score findByStuNum(int stuNum);
}
