package com.spring.mvc.chap01;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

//1.어떤 요청들을 처리할지 공통 URL을 설계
@RequestMapping("/spring/*")
//2.이 클래스의 객체를 스프링이 관리하도록 빈을 등록
@Controller //Component와 같은 개념
public class ControllerV1 {

    //세부요청들은 메서드를 통해 처리
    @RequestMapping("/hello") //http://localhost:8181/spring/hello
    public String hello() {
        System.out.println("\n====== hello 요청이 들어옴 ======\n");
        //어떤 jsp를 열어줄지 경로 기입

//      return "/WEB-INF/views/hello.jsp";
        return "hello";

        //http://localhost:8181/spring/hello을 입력하면
        // /WEB-INF/views/hello.jsp파일을 열어준다.
    }

    // /spring/food 요청이 오면 food.jsp를 연다.
    @RequestMapping("/food")
    public String food(){
        System.out.println("food OPEN");
        return "chap01/food";
    }

    /**
     *  =================== 요청 파라미터 읽기 (Query String parameter) ===================
     *  방법1. HttpServletRequest 객체 사용
     *  ==> ex) /spring/person?name=kim&age=30
     */


    //요청을 받는 메서드
    @RequestMapping("/person")
    public String person(HttpServletRequest request){
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        System.out.println("name = " + name);
        System.out.println("age = " + age);
        return "";
    }


    /**
     *   방법2. @RequestParam 사용
     *   ==> ex) /spring/major?stu=kim&major=business&grade=3
     */

    @RequestMapping("/major")
    public String major(
                         //@RequestParam 생략 가능(주소값이름과 파라미터의 이름이 같고, 다른 설정을 하지 않을 때 생략 가능)
                         String stu,
                         @RequestParam("major") String mj,
                         //지역변수에 같은 이름이 있어서 겹칠 때
                         //클라이언트가 보내면 mj라는 변수에 담겠다.

                         //기본값 설정(값을 보내지 않았을 때)
                         @RequestParam(defaultValue = "1") int grade)
    {
        String major = "전공";


        System.out.println("stu = " + stu);
        System.out.println("mj = " + mj);
        System.out.println("grade = " + grade);
        return "";
    }

    /**
     *   방법3. 커맨드 객체 사용
     *   파라미터의 쿼리스트링의 양이 너무 많을 경우 또는
     *   연관성이 있을 경우에 사용한다.
     *   제일 많이 사용(객체로 받기 때문에 편리하다)
     *   ==> ex) /spring/order?oNum=20230230232-P&goods=구두&amount=3&price=50000....
     */

    @RequestMapping("/order")
    public String order(OrderRequestDTO dto){
        System.out.println("dto = " + dto);
//        int amount = dto.getAmount();
        return "";
    }

    /**
     *   방법4. URL에 경로로 붙어있는 데이터 읽기
     *    ==> ex) /spring/member/hong/107
     *   hong이라는 유저의 107번 게시글을 읽고싶다.
     *   ?가 없어지고 /로 사용
     */
    @RequestMapping("/member/{userName}/{bNo}")
    public String member(
            // @PathVariable : '/'뒤에 있는 걸 읽음. 생략 불가
            @PathVariable String userName,
            @PathVariable long bNo
    ){
        System.out.println("userName = " + userName);
        System.out.println("bNo = " + bNo);
        return "";
    }

    //음식 선택 요청 처리
//    @RequestMapping(value = "/food-select",method = RequestMethod.POST)
    @PostMapping("/food-select")
    public String foodSelect(
            @RequestParam String foodName,
            @RequestParam String category
    ){
        System.out.println("foodName = " + foodName);
        System.out.println("category = " + category);
        return "hello";
    }

}
