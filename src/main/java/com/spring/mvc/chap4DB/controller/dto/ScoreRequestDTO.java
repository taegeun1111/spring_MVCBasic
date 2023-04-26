package com.spring.mvc.chap4DB.controller.dto;


import lombok.*;


/**
 * dto는 noArg와 Setter는 필수
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ScoreRequestDTO {
    private String name;
    private int kor,eng,math;
}
