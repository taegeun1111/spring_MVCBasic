package com.spring.mvc.chap05.controller;

import com.spring.mvc.chap05.dto.BoardListResponseDTO;
import com.spring.mvc.chap05.dto.BoardSaveRequestDTO;
import com.spring.mvc.chap05.dto.Page.Page;

import com.spring.mvc.chap05.dto.Page.PageMaker;
import com.spring.mvc.chap05.entity.Board;
import com.spring.mvc.chap05.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
@Slf4j
public class BoardController {
    private final BoardService boardService;

    //목록조회 기능
    @GetMapping("/list")
    public String list(Page page,Model model){
        log.info("/board/list : GET");
        log.info("page : {}", page);
        //페이징 알고리즘 작동
        PageMaker maker = new PageMaker(page, boardService.getCount());
        log.info("page maker: {}", maker);
        List<BoardListResponseDTO> list = boardService.getList(page);
        model.addAttribute("blist",list);
        model.addAttribute("maker",maker);

        return "chap05/list";
    }


    @GetMapping("/detail")
    public String detail(int boardNo, Model model){
        System.out.println("get발생!");
        Board oneList = boardService.getOneList(boardNo);
        model.addAttribute("one",oneList);
        return "chap05/list-detail";
    }

//    @GetMapping("/write")
//    public String save(String title ,String Content){
//        return "/chap05/list-insert";
//    }
//
//    @GetMapping("/register")
//    public String write(BoardSaveRequestDTO dto){
//        //객체를 받아오기 (post)
//        boardService.insert(dto.getTitle(),dto.getContent());
//        System.out.println(dto.getTitle());
//        System.out.println(dto.getContent());
//
//        return "redirect:/board/list";
//    }

    // 글쓰기 화면 조회 요청
    @GetMapping("/write")
    public String write() {
        System.out.println("/board/write : GET");
        return "chap05/list-insert";
    }

    // 글 등록 요청 처리
    @PostMapping("/write")
    public String write(BoardSaveRequestDTO dto) {
        System.out.println("/board/write : POST");
        boardService.register(dto);
        return "redirect:/board/list";
    }

    @GetMapping("/delete")
    public String delete(int boardNo){
        System.out.println("/board.delete : GET");
        boardService.deleteNum(boardNo);
        return "redirect:/board/list";
    }
}

