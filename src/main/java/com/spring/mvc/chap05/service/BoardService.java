package com.spring.mvc.chap05.service;

import com.spring.mvc.chap05.dto.BoardListResponseDTO;
import com.spring.mvc.chap05.dto.BoardSaveRequestDTO;
import com.spring.mvc.chap05.entity.Board;
import com.spring.mvc.chap05.repository.BoardMapper;
import com.spring.mvc.chap05.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
//    private final BoardRepository boardRepository;
    private final BoardMapper boardRepository;
    private static int count;
    //중간처리 기능 자유롭게 사용

    //전체 중 게시글 번호를 제외한 값들 반환
    public List<BoardListResponseDTO> getList() {
        List<Board> allBoardList = boardRepository.findAll();
        List<BoardListResponseDTO> allList = allBoardList.stream()
                .map(BoardListResponseDTO::new)
                .collect(Collectors.toList());
        return allList;
    }

    public Board getOneList(int boardNo) {
        Board one = boardRepository.findOne(boardNo);
        boardRepository.upViewCount(boardNo);
        return one;
    }

    public boolean register(BoardSaveRequestDTO dto) {
        return boardRepository.save(new Board(dto));
    }

    public boolean deleteNum(int boardNo){
        return boardRepository.deleteByNo(boardNo);
    }
}
