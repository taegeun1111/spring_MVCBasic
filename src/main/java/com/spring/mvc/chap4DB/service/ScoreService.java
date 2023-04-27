package com.spring.mvc.chap4DB.service;

import com.spring.mvc.chap4DB.Repository.ScoreRepository;
import com.spring.mvc.chap4DB.controller.dto.ScoreListResponseDTO;
import com.spring.mvc.chap4DB.controller.dto.ScoreRequestDTO;
import com.spring.mvc.chap4DB.entity.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 컨트롤러와 레파지토리 사이 비지니스 로직 처리
 * ex) 트랜잭션 처리, 예외처리, dto변환처리
 */
@Service
public class ScoreService {

    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreService(@Qualifier("spring") ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    //목록조회 중간처리
    /*
        컨트롤러는 데이터베이스를 통해
        성적정보 리스트를 가져오길 원한다.
        그런데 데이터베이스는 성적정보를 전부 모아서 준다.
        컨트롤러는 일부만 원한다.

     */
    public List<ScoreListResponseDTO> getList(String sort){
        /**
         * 정리필요
         */
        List<Score> slist = scoreRepository.findAll(sort);

        List<ScoreListResponseDTO> responstDtoList = slist.stream()
                .map(ScoreListResponseDTO::new)
                //.map(s -> new ScoreListResponseDTO(s))
                .collect(Collectors.toList());
//
        return responstDtoList;
    }

    /*
        변경전
       public List<ScoreListResponseDTO> getList(String sort){
        List<Score> slist = scoreRepository.findAll(sort);

        List<ScoreListResponseDTO> responstDtoList = slist.stream()
                .map(ScoreListResponseDTO::new)
                //.map(s -> new ScoreListResponseDTO(s))
                .collect(Collectors.toList());

        return responstDtoList;
    }
     */

    //등록 중간처리
    //컨트롤러는 나에게 DTO를 줬지만
    //레파지토리는 ScoreEntity를 달라고 한다.
    public boolean insertScore(ScoreRequestDTO dto){
        return scoreRepository.save(new Score(dto));
    }

    //삭제 중간처리
    public boolean delete(int stuNum){
        return scoreRepository.deleteByStuNum(stuNum);
    }

    //상세조회, 수정화면조회 중간처리
    public Score retrieve(int stuNum){
        return scoreRepository.findByStuNum(stuNum);
    }
}
