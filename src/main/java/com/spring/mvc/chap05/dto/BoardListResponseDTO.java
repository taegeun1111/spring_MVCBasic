package com.spring.mvc.chap05.dto;

import com.spring.mvc.chap04.entity.Score;
import com.spring.mvc.chap05.entity.Board;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class BoardListResponseDTO {
    private final int boardNo;
    private final String shortTitle;  //제목
    private final String shortContent; //내용
    private final int viewCount; //조회수
    private final String date; //작성일자시간

    public BoardListResponseDTO(Board s) {
        this.boardNo = s.getBoardNo();
        this.shortTitle = makeShortTitle(s.getTitle());
        this.shortContent = makeShortContent(s.getContent());
        this.viewCount = s.getViewCount();
        this.date = makePrettierDateString(LocalDateTime.now());
    }

    static String makePrettierDateString(LocalDateTime regDateTime) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return pattern.format(regDateTime);
    }

    private static String makeShortTitle(String originContent) {
        return makeSlice(originContent, 7);
    }

    private static String makeShortContent(String originContent) {
        return makeSlice(originContent, 30);
    }

    private static String makeSlice(String targetString, int wishLength) {
        return (targetString.length() > wishLength)
                ? targetString.substring(0, wishLength) + "..."
                : targetString;
    }
}
