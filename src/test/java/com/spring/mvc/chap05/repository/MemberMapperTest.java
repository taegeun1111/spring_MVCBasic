package com.spring.mvc.chap05.repository;

import com.spring.mvc.chap05.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberMapperTest {
    @Autowired
    MemberMapper memberMapper;

    @Autowired
    PasswordEncoder encoder;

    @Test
    @DisplayName("회원가입에 성공해야 한다.")
    void saveTest(){
        //given
        Member member = Member.builder()
                .account("lion")
                .password(encoder.encode("1111"))
                .name("사자")
                .email("lion@aaa.aaa")
                .build();
        //when
        boolean save = memberMapper.save(member);

        //then
        assertTrue(save);
    }

    @Test
    @DisplayName("peach라는 계정명으로 회원을 조회하면" +
            "그 회원의 이름이 복숭아여야 한다.")
    void findMemberTest(){
        //given
        String acc = "peach";

        //when
        Member foundMember = memberMapper.findMember(acc);

        //then
        System.out.println("foundMember = " + foundMember);
        assertEquals("복숭아",foundMember.getName());
    }

    @Test
    @DisplayName("계정명이 peach인 경우 결과값이 1이 나와야 한다.")
    //중복되는 경우 1, 신규 멤버의 경우 0
    void accountDuplicateTest(){
        //given
        String acc = "peach";
        String email = "peach@aaa.aaa";
        //when
        int account = memberMapper.isDuplicate("email", email);
        //then
        System.out.println("account = " + account);
        assertEquals(1,account);
    }

    @Test
    @DisplayName("비밀번호가 암호화 되어야 한다.")
    void encodingTest(){
        //인코딩 전 패스워드
        String rawPassword = "abc1234!";

        //인코딩 후 패스워드
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println("encodedPassword = " + encodedPassword);
    }
}