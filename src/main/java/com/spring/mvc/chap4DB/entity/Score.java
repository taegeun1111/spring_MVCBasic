package com.spring.mvc.chap4DB.entity;

import com.spring.mvc.chap4DB.controller.dto.ScoreRequestDTO;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.spring.mvc.chap4DB.entity.Grade.*;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
//하나의 학생 정보
public class Score {
    //클라이언트에서 주는 데이터
    private String name;
    private int kor,eng,math;

    //서버에서 만드는 데이터
    private int stuNum; //학번
    private int total;
    private double average;
    private Grade grade;

    public Score(ScoreRequestDTO dto) {
        this.name = dto.getName();
        this.kor = dto.getKor();
        this.eng=dto.getEng();
        this.math = dto.getMath();
        calcTotalAngAvg(); //총점, 평균, 계산
        calcGrade();
    }
    public Score(ResultSet rs) throws SQLException {
        this.stuNum = rs.getInt("stu_num");
        this.name = rs.getString("name");
        this.kor = rs.getInt("kor");
        this.eng = rs.getInt("eng");
        this.math = rs.getInt("math");
        this.total = rs.getInt("total");
        this.average = rs.getDouble("average");
        this.grade = Grade.valueOf(rs.getString("grade"));
    }


    public void calcGrade() {
        if(average >= 90){
            this.grade = A;
        }else if (average >= 80){
            this.grade = B;
        }else if (average >= 70){
            this.grade = C;
        }else if (average >= 60){
            this.grade = D;
        }else {
            this.grade = F;
        }
    }

    public void calcTotalAngAvg() {
        this.total = kor+eng+math;
        this.average =(Math.round((total/3.0)*100)/100);
    }
}
