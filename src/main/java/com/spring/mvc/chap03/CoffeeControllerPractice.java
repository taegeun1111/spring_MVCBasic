package com.spring.mvc.chap03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/coffee")
@Controller
public class CoffeeControllerPractice {

    @RequestMapping("/order")
    public String order(){
        return "/chap03/coffee-form";
    }

    //                <li># 주문하신 메뉴: ${menu}</li>
    //                <li># 지불하실 가격: ${p}원</li>
    @PostMapping("/result")
    public String result(String menu,@RequestParam(defaultValue = "3000") int price, Model model){
        model.addAttribute("menu",menu);
        model.addAttribute("p",price);
        return "/chap03/coffee-result";
    }
}
