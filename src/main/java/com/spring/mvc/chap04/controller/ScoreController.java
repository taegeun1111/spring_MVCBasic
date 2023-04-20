package com.spring.mvc.chap04.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 요청 URL
 * 1.학생 성적 정보 등록화면을 보여주고 성적 정보 목록조회 처리
 * - /score/list : GET
 * <p>
 * 2.성적 정보 등록 처리 요청
 * - /score/register : POST
 * <p>
 * 3.성적 정보 삭제 요청
 * - /score/remove : POST
 * <p>
 * 4.성적 정보 상세 조회 요청
 * - /score/detail : GET
 */
@Controller
@RequestMapping("/score")
public class ScoreController {

    //성적등록화면 띄우기 + 정보목록죄회
    @GetMapping("/list")
    public String list() {
        System.out.println("/score/list : GET");
        return "";
    }

    @PostMapping("/register")
    public String register() {
        System.out.println("/score/register : POST");
        return "";
    }

    @PostMapping("/remove")
    public String remove() {
        System.out.println("/score/remove : POST");
        return "";
    }

    @GetMapping("/detail")
    public String detail() {
        System.out.println("/score/detail : GET");
        return "";
    }

}
