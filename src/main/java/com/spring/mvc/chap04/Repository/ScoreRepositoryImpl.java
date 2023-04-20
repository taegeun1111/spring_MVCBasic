package com.spring.mvc.chap04.Repository;

import com.spring.mvc.chap04.entity.Grade;
import com.spring.mvc.chap04.entity.Score;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

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
        Score stu1 = new Score("뽀로로", 100, 50, 80, ++sequence, 0, 0, Grade.A);
        Score stu2 = new Score("크롱", 70, 80, 100, ++sequence, 0, 0, Grade.A);
        Score stu3 = new Score("꼬부기", 30, 40, 30, ++sequence, 0, 0, Grade.A);

        scoreMap.put(stu1.getStuNum(), stu1);
        scoreMap.put(stu2.getStuNum(), stu2);
        scoreMap.put(stu3.getStuNum(), stu3);
    }

    @Override
    public List<Score> findAll() {
        return new ArrayList<>(scoreMap.values())
                .stream()
                .sorted(comparing(Score::getStuNum))
                .collect(Collectors.toList());

    }

    @Override
    public boolean save(Score score) {
        if (scoreMap.containsKey(score.getStuNum())) {
            return false;
        }
        scoreMap.put(score.getStuNum(), score);
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