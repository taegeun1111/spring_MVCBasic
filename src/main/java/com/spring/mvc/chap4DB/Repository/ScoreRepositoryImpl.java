package com.spring.mvc.chap4DB.Repository;

import com.spring.mvc.chap4DB.controller.dto.ScoreRequestDTO;
import com.spring.mvc.chap4DB.entity.Score;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;


@Repository("memory") //빈 등록 : 객체 생성 제어권을 스프링에게 위임(Component와 동일 명시적으로 하기 위해 사용)
public class ScoreRepositoryImpl implements ScoreRepository {

    /**
     * key:학번, value:성적정보
     * 외부에서 접근하면 안되기 때문에 private, 하나의 정보 static,final
     * <p>
     * sequence:학번에 사용할 일련번호
     */

    private static int sequence;

    private static final Map<Integer, Score> scoreMap;

    static {
        scoreMap = new HashMap<>();
        Score stu1 = new Score(new ScoreRequestDTO("뽀로로",100,34,91));
        Score stu2 = new Score(new ScoreRequestDTO("대길이",60,60,60));
        Score stu3 = new Score(new ScoreRequestDTO("춘식이",50,40,30));

        stu1.setStuNum(++sequence);
        stu2.setStuNum(++sequence);
        stu3.setStuNum(++sequence);

        scoreMap.put(stu1.getStuNum(), stu1);
        scoreMap.put(stu2.getStuNum(), stu2);
        scoreMap.put(stu3.getStuNum(), stu3);
    }

    @Override
    public List<Score> findAll(String sort) {
        Comparator<Score> comparing = comparing(Score::getStuNum);
        switch (sort){
            case "num" :
                comparing = comparing(Score::getStuNum);
                break;
            case "name" :
                comparing = comparing(Score::getName);
                break;
            case "avg" :
                comparing = comparing(Score::getAverage).reversed();
                break;
        }

        return scoreMap.values()
                .stream()
                .sorted(comparing)
                .collect(Collectors.toList());
    }

    @Override
    public List<Score> findAll() {
        return scoreMap.values()
                .stream()
                .sorted(comparing(Score::getStuNum))
                .collect(Collectors.toList());
    }


    @Override
    public boolean save(Score score) {
        if (scoreMap.containsKey(score.getStuNum())) {
            return false;
        }
        //메서드 오류 점검 후 추가
        score.setStuNum(++sequence);

        scoreMap.put(score.getStuNum(), score);
//        System.out.println(findAll());
        return true;
    }

    @Override
    public boolean deleteByStuNum(int stuNum) {
        if (!scoreMap.containsKey(stuNum)) {
            return false;
        }
        scoreMap.remove(stuNum);
        return true;
    }

    @Override
    public Score findByStuNum(int stuNum) {
        Score score = scoreMap.get(stuNum);
        return score;
    }
}
