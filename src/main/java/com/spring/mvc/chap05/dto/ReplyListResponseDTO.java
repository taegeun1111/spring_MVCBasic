package com.spring.mvc.chap05.dto;

import com.spring.mvc.chap05.dto.Page.PageMaker;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter @Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyListResponseDTO {
    private int count; // 총 댓글 수
    private PageMaker pageInfo; // 페이지 정보
    private List<ReplyDetailResponseDTO> replies; // 댓글 리스트
}
