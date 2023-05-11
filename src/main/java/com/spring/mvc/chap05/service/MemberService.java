package com.spring.mvc.chap05.service;

import com.spring.mvc.chap05.dto.LoginRequestDTO;
import com.spring.mvc.chap05.dto.LoginResult;
import com.spring.mvc.chap05.dto.SignUpRequestDTO;
import com.spring.mvc.chap05.entity.Member;
import com.spring.mvc.chap05.repository.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.spring.mvc.chap05.dto.LoginResult.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder encoder;

    //회원가입 처리 서비스
    public boolean join(final SignUpRequestDTO dto) {

        //dto를 entity로 변환
        Member member = Member.builder()
                .account(dto.getAccount())
                .email(dto.getEmail())
                .name(dto.getName())
                .password(encoder.encode(dto.getPassword()))
                .build();

        // 매퍼에게 회원정보 전달해서 저장명령
        return memberMapper.save(member);
    }

        public boolean checkSignUpValue(String type, String keyword){
            int flagNum = memberMapper.isDuplicate(type, keyword);

            return flagNum == 1;
        }


    public LoginResult authenticate(LoginRequestDTO dto) {
        Member foundMember = memberMapper.findMember(dto.getAccount());

        //회원가입 여부 확인
        if (foundMember == null){
            log.info("{} - 회원가입 먼저 해주세요",dto.getAccount());
            return NO_ACC;
        }
        //비밀번호 일치 확인
        if (!encoder.matches(dto.getPassword(),foundMember.getPassword())){
            log.info("{} - 비밀번호 불일치",dto.getPassword());
            return NO_PW;
        }
        return SUCCESS;

    }
}
