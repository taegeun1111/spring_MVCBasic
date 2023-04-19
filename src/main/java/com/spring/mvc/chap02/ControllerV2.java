package com.spring.mvc.chap02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/model/*")
public class ControllerV2 {

    /**
     * 방법1. Model 사용하기
     */

    @GetMapping("/hobbies")
    public String hobbies(Model model){
        String name = "멍멍이";
        List<String> hobbies = List.of("산책","밥먹기","낮잠");
        model.addAttribute("n",name);
        model.addAttribute("hList",hobbies);
        return "chap02/hobbies";
    }


    //-------------------------------------------------------

    /**
     * 방법2. ModelAndView 사용하기
     * /model/hobbies2 : GET
     * hobbies.jsp를 포워딩
     */

    //ModelAndView는 리턴 타입을 ModelAndView로 설정해야 한다.
    @GetMapping("/hobbies2")
    public ModelAndView hobbies2(){

        //jsp로 보내야 할 데이터
        String name = "짹짹이";
        List<String> hList = List.of("전깃줄에서 졸기", "조잘대기");

        //포워딩할 뷰의 이름
        String viewName = "chap02/hobbies";

        ModelAndView mv = new ModelAndView();
        mv.setViewName(viewName);
        mv.addObject("n",name);
        mv.addObject("hList",hList);

        return mv;
    }





}
