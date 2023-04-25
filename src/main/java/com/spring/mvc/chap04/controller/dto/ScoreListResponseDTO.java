package com.spring.mvc.chap04.controller.dto;

import com.spring.mvc.chap04.entity.Grade;
import com.spring.mvc.chap04.entity.Score;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

//entity 이름 + Response(or Request) + DTO
@RequiredArgsConstructor //final만 골라서 초기화
@Getter //final이기 때문에 setter 없음
@ToString
@EqualsAndHashCode
public class ScoreListResponseDTO {

    private final int stuNum;
    private final String maskingName; //첫 글자 제외 *처리
    private final double average;
    private final Grade grade;

    public ScoreListResponseDTO(Score s) {
        this.stuNum= s.getStuNum();
        this.maskingName = makeMaskingName(s.getName());
        this.average = s.getAverage();
        this.grade = s.getGrade();
    }


    private String makeMaskingName(String originalName){
        String makingName = String.valueOf(originalName.charAt(0));

        for (int i = 1; i <originalName.length(); i++) {
            makingName += "*";
        }
        return makingName;
    }

}
