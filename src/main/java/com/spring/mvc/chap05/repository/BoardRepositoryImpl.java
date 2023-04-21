package com.spring.mvc.chap05.repository;

import com.spring.mvc.chap05.entity.Board;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class BoardRepositoryImpl implements BoardRepository{
    private final static Map<Integer,Board> boardMap;
    private static int sequence;
    private static int count;

    static {
        boardMap = new HashMap<>();
        Board board1 = new Board(++sequence, "돈까스 레시피", "그냥 이마트에서 사서 에어프라이 돌려라~");
        Board board2 = new Board(++sequence, "관종의 조건", "이 세상은 나를 중심으로 돌아간다라는 마음으로 행동해라ㅋㅋ");
        Board board3 = new Board(++sequence, "이마트 영업시간", "10시에 마감하는걸로 바뀌었나요?? 마감털이 몇시에 가야되죠?? 하.....");

        boardMap.put(board1.getBoardNo(), board1);
        boardMap.put(board2.getBoardNo(),board2);
        boardMap.put(board3.getBoardNo(),board3);
    }

    //게시물 목록 조회
    @Override
    public List<Board> findAll() {
        List<Board> boardList = boardMap.values().stream()
                .sorted(Comparator.comparing(Board::getBoardNo).reversed())
                .collect(Collectors.toList());
        return boardList;
    }


    //한 명만 조회
    @Override
    public Board findOne(int boardNo) {
        Board board = boardMap.get(boardNo);
        board.setViewCount(board.getViewCount()+1);
        return board;
    }

    //추가하기
    @Override
    public boolean save(Board board) {
        board.setBoardNo(++sequence);
        boardMap.put(board.getBoardNo(), board);
        return true;
    }

    @Override
    public boolean deleteByNo(int boardNo) {
        if (!boardMap.containsKey(boardNo)) {
            return false;
        }
        boardMap.remove(boardNo);
        return true;
    }

}
