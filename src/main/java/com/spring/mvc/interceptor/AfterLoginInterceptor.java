package com.spring.mvc.interceptor;

import com.spring.mvc.util.LoginUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//로그인 이후 비회원 관련 페이지 진입 차단
@Configuration
public class AfterLoginInterceptor implements HandlerInterceptor {

    //컨트롤러 진입 전
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (LoginUtil.isLogin(session)){
            response.sendRedirect("/");
            return false;
        }
        return true;
    }


}
