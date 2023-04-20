package com.spring.mvc.chap04.Repository;

import com.spring.mvc.chap04.entity.Score;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreRepositoryImplTest {

    ScoreRepository repository = new ScoreRepositoryImpl();

    /**
     *  단위 테스트(Unit test)
     *  테스트 시나리오
     *  - 단언(Assertion) 기법(확정문법)
     */
    @Test
    @DisplayName("저장소에서 findAll을 호출하면 반환된 리스트에는 성적정보가 3개 있어야 한다.'")
    void findAllTest(){
        //given-when-then 패턴
        //given:테스트를 위해 주어질 데이터 (ex:parameter)

        //when:테스트 실제 상황
        List<Score> scoreList = repository.findAll();
        //then:테스트 결과 확인
        System.out.println(scoreList.size()==3);
        //나는 스코어리스트의 사이즈가 3인 것이 참이라고 단언한다.
//        Assertions.assertTrue(scoreList.size()==3);
//        Assertions.assertEquals(3,scoreList.size());

        //나는 리스트의 첫번째 객체의 이름이 뽀로로라고 단언한다.
        Assertions.assertEquals("뽀로로",scoreList.get(0).getName());

    }


    @Test
    @DisplayName("저장소에서 findByStuNum을 호출하여" +
            "학번이 2인 학생을 조회하면 그 학생의 국어점수가" +
            "33점이고 이름이 춘식이어야 한다.")
    void stuTest(){
        //given : stuNum
        int stuNum = 2;
        //when
        Score score = repository.findByStuNum(stuNum);
        //then
        Assertions.assertEquals(70, score.getKor());
        Assertions.assertEquals("크롱", score.getName());

    }



}











