package com.spring.mvc.chap04.entity;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
//하나의 학생 정보
public class Score {
    private String name;
    private int kor,eng,math;

    private int stuNum; //학번
    private int total;
    private double average;
    private Grade grade;
}
