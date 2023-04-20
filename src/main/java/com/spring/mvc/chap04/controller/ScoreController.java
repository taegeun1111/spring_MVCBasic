package com.spring.mvc.chap04.controller;


import com.spring.mvc.chap04.Repository.ScoreRepositoryImpl;
import com.spring.mvc.chap04.controller.dto.ScoreRequestDTO;
import com.spring.mvc.chap04.entity.Score;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


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
//@AllArgsConstructor : 모든 필드를 초기화하는 생성자
@RequiredArgsConstructor // final 필드만 초기화하는 생성자
@RequestMapping("/score")
public class ScoreController {
    //저장소에 의존해야 데이터를 받아서 클라이언트에게 응답할 수 있다.
    //주입 객체는 불변성을 유지하기 위해 final
    private final ScoreRepositoryImpl repository;

    /**
     * 클래스의 생성자가 단 1개라면
     * 자동 @Autowired를 써준다.
     * 하단 코드는 lombok을 사용하여
     * @RequiredArgsConstructor 또는 ,@AllArgsConstructor로 생성자를 만듦
     */
//    @Autowired //자동 주입
//    public ScoreController(ScoreRepositoryImpl repository) {
//        this.repository = repository;
//    }

    //성적등록화면 띄우기 + 정보목록조회
    @GetMapping("/list")
    public String list(Model model) {
        List<Score> slist = repository.findAll();
        model.addAttribute("sList",slist);
        System.out.println("/score/list : GET");
        return "chap04/score-list";
    }

    @PostMapping("/register")
    public String register(ScoreRequestDTO dto) {
        //입력데이터(쿼리스트링) 읽기
        System.out.println("/socre/register dto = " + dto);

        //dto로 추가한 데이터를 score로 변환해야 한다.
        //dto(ScoreDTO)를 entity(Score)로 변환해야 한다.
        Score score = new Score(dto);

        //save명령
        repository.save(score);
        /*
         등록요청에서 JSP 뷰 포워딩을 하면
         갱신된 목록을 다시 한 번 저장소에서 불러와
         모델에 담는 추가적인 코드가 필요하지만

         리다이렉트를 통해서 위에 만든 /score/list : GET
         을 자동으로 다시 보낼 수 있다면 번거로운 코드가
         줄어들 수 있다. -> 리다이렉트
         */
        //"redirect : 요청URL"
        return "redirect:/score/list";
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
