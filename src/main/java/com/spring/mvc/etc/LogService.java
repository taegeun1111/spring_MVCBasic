package com.spring.mvc.etc;

import org.springframework.stereotype.Component;

@Component
public class LogService {

    /*
        - 로그:발생시간, 로그 레벨, 파일저장
        - 로그 라이브러리:logback,log4j,slf4j
     */
    public void showLog(){
        System.out.println("log");
    }
}
