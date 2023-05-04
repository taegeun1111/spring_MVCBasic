package com.spring.mvc.chap05.dto;

import com.spring.mvc.chap05.entity.Reply;
import lombok.*;

import javax.validation.constraints.*;

@Setter
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class ReplyModifyRequestDTO {

    @NotNull
    @Min(0) @Max(Long.MAX_VALUE) //반드시 정수 입력하도록 체크
    private Long boardNo;
    @NotNull
    @Min(0) @Max(Long.MAX_VALUE)
    private Long replyNo;
    @NotBlank
    @Size(min = 1)
    private String text;


    public Reply toEntity() {
        return Reply.builder()
                .replyNo(this.replyNo)
                .boardNo(this.boardNo)
                .replyText(this.text)
                .build();
    }

}
