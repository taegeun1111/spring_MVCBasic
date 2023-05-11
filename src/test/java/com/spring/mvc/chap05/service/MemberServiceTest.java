package com.spring.mvc.chap05.service;

import com.spring.mvc.chap05.dto.LoginRequestDTO;
import com.spring.mvc.chap05.dto.LoginResult;
import com.spring.mvc.chap05.dto.SignUpRequestDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {
    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("SignUpDTO를 전달하면 회원가입에 성공해야 한다.")
    void joinTest(){
        //given
        SignUpRequestDTO dto = new SignUpRequestDTO();
        dto.setAccount("테스트2");
        dto.setPassword("lalal2");
        dto.setName("홍길동2");
        dto.setEmail("aaa2@ddd.com");
        //when
        memberService.join(dto);
    }

    @Test
    @DisplayName("계정명이 abcd인 회원의 로그인 시도 결과 검증을 상황별로 수행해야 한다.")
    void loginTest(){
        //given
        LoginRequestDTO dto = new LoginRequestDTO();
        dto.setAccount("abcd");
        dto.setPassword("1234!");

        //when
        LoginResult result = memberService.authenticate(dto);

        //then
        assertEquals(LoginResult.SUCCESS, result);
    }

}