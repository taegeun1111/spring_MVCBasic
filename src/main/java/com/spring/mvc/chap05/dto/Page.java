package com.spring.mvc.chap05.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class Page {
    private int pageNo; //클라이언트가 보낸 페이지 번호
    private int amount; //클라이언트가 보낸 목록게시물 수


    //기본값 설정
    public Page(){
        this.pageNo = 1;
        this.amount = 6;
    }

    public int getPageStart() {
        /*
            pageNo : 1 -> return 0
            pageNo : 2 -> return 6
            pageNo : 3 -> return 12
            pageNo : n -> return (n-1)*6
         */

        return (pageNo - 1) * amount;
    }
}
