package com.spring.mvc.chap05.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class BoardSaveRequestDTO {
    private final String title;  //제목
    private final String content; //내용
}
