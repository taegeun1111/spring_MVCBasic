package com.spring.mvc.chap05.dto;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
//ResponseDTO 서버가 클라이언트한테 주는 데이터
public class LoginUserResponseDTO {
    private String account;
    private String nickname;
    private String email;


}
