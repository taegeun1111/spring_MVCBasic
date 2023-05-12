package com.spring.mvc.chap05.entity;

import com.spring.mvc.chap05.dto.BoardSaveRequestDTO;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Board {
    private int boardNo;  //게시글 번호
    private String title;  //제목
    private String content; //내용
    private int viewCount; //조회수
    private LocalDateTime regDateTime; //작성일자시간
    private String account; //작성자 계정명

    public Board(int boardNo, String title, String content) {
        this.boardNo = boardNo;
        this.title = title;
        this.content = content;
        this.regDateTime = LocalDateTime.now();
    }

    public Board(BoardSaveRequestDTO dto){
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.regDateTime = LocalDateTime.now();
    }

}
