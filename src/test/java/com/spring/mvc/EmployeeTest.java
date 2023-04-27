package com.spring.mvc;

import com.spring.mvc.etc.Actor;
import com.spring.mvc.etc.Employee;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class EmployeeTest {

    @Test
    void test(){
        Employee build = Employee.builder()
                .position("대리")
                .empName("홍길동")
                .empId(99)
                .hireDate(LocalDate.of(2019,3,15))
                .build();


        System.out.println("build = " + build);
    }

    @Test
    void ttt(){
        Actor build = Actor.builder()
                .actorAge(20)
                .build();
        System.out.println("build = " + build);
    }
}