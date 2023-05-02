package com.spring.mvc.chap05.dto.Page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
public class Search extends Page {

    //검색 타입(INUM으로 사용 가능), 검색 키워드
    private String type;
    private String keyword;

    public Search() {
        this.type = "";
        this.keyword = "";
    }
}
